package com.example.mobilelele.web;

import com.example.mobilelele.models.security.CurrentUser;
import com.example.mobilelele.models.view.UserLoginViewModel;
import com.example.mobilelele.models.view.UserRegisterViewModel;
import com.example.mobilelele.models.view.UserRoleSetServiceModel;
import com.example.mobilelele.services.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserControler {
    private final UserServices userServices;
    private final CurrentUser currentUser;

    public UserControler(UserServices userServices, CurrentUser currentUser) {
        this.userServices = userServices;
        this.currentUser = currentUser;
    }

    @ModelAttribute("userModel")
    public UserLoginViewModel userModel() {
        return new UserLoginViewModel();
    }

    @GetMapping("/login")
    public String loginForm() {
        return "auth-login";
    }

    @PostMapping("/login")
    public String loginUser(@Valid @ModelAttribute UserLoginViewModel userModel,
                            BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel",
                    bindingResult);
            return "redirect:/users/login";
        }
        if (userServices.haveUser(userModel.getUsername(), userModel.getPassword())) {
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:/users/login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        currentUser.setAnonymous(true);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        if (!model.containsAttribute("userRegisterModel")) {
            model.addAttribute("userRegisterModel", new UserRegisterViewModel());
        }
        return "auth-register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserRegisterViewModel userModel,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            return "redirect:/users/register";
        }
        if (this.userServices.registerUser(userModel)) {
            return "redirect:/users/login";
        } else {
            return "redirect:/users/register";
        }
    }


}
