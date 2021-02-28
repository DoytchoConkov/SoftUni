package com.example.mobilelele.web;

import com.example.mobilelele.models.entities.Category;
import com.example.mobilelele.models.view.BrandAddViewModel;
import com.example.mobilelele.models.view.ModelAddViewModel;
import com.example.mobilelele.models.view.UserRoleSetServiceModel;
import com.example.mobilelele.services.BrandServices;
import com.example.mobilelele.services.ModelServices;
import com.example.mobilelele.services.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/admin")
public class AdminControler {
    private final BrandServices brandServices;
    private final ModelServices modelServices;
    private final UserServices userServices;

    public AdminControler(BrandServices brandServices, ModelServices modelServices, UserServices userServices) {
        this.brandServices = brandServices;
        this.modelServices = modelServices;
        this.userServices = userServices;
    }

    @GetMapping("addBrand")
    public String addBrandView(Model model) {
        if (!model.containsAttribute("brandAddViewModel")) {
            model.addAttribute("brandAddViewModel", new BrandAddViewModel());
        }
        return "brand-add";
    }

    @PostMapping("/addBrand")
    public String addBrand(@Valid BrandAddViewModel brandAddViewModel, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("brandAddViewModel", brandAddViewModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.brandAddViewModel", bindingResult);
            return "redirect:/admin/addBrand";
        }
        if (brandServices.addBrand(brandAddViewModel.getName())) {
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("brandAddViewModel", brandAddViewModel);
        redirectAttributes.addFlashAttribute("existBrand", true);
        return "redirect:/admin/addBrand";
    }

    @GetMapping("addModel")
    public String viewAllBrands(Model model) {
        if (!model.containsAttribute("modelAddViewModel")) {
            model.addAttribute("modelAddViewModel", new ModelAddViewModel());
            List<String> brands=this.brandServices.allBrands();
            List<String> categories = Stream.of(Category.values()).map(Enum::name).collect(Collectors.toList());
            model.addAttribute("brands",brands);
            model.addAttribute("categories",categories);
            model.addAttribute("existModel", false);
        }
        return  "model-add";
    }
    @PostMapping("/addModel")
    public String addModel(@Valid ModelAddViewModel modelAddViewModel, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("modelAddViewModel", modelAddViewModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modelAddViewModel", bindingResult);
            return "redirect:/admin/addModel";
        }
        if (modelServices.addModel(modelAddViewModel)) {
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("modelAddViewModel", modelAddViewModel);
        redirectAttributes.addFlashAttribute("existModel", true);
        return "redirect:/admin/addModel";
    }
    @GetMapping("/set-role")
    public String role( Model model) {
        if (!model.containsAttribute("userRoleSetServiceModel")) {
            model.addAttribute("userRoleSetServiceModel", new UserRoleSetServiceModel());
        }
        model.addAttribute("usernames", userServices.getUsers());
        return "user-role";
    }

    @PostMapping("/set-role")
    public String addRole(@Valid UserRoleSetServiceModel userRoleSetServiceModel,
                          BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            //TODO: check if roles is empty
            redirectAttributes.addFlashAttribute("userRoleSet", userRoleSetServiceModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            return "redirect:/users/set-role";
        }
        userServices.setRole(userRoleSetServiceModel);
        return "redirect:/";
    }
}
