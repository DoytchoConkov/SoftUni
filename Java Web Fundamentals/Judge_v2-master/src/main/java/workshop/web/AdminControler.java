package workshop.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import workshop.models.bindingModels.ExerciserBindingModel;
import workshop.models.bindingModels.UserRoleBindingModel;
import workshop.models.services.ExerciseServiceModel;
import workshop.services.ExerciseService;
import workshop.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/")
public class AdminControler {
    private final UserService userService;
    private final ExerciseService exerciseService;
    private final ModelMapper modelMapper;

    public AdminControler(UserService userService, ExerciseService exerciseService, ModelMapper modelMapper) {
        this.userService = userService;
        this.exerciseService = exerciseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add/role")
    public String addRole(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "role-add";
    }

    @PostMapping("/add/role")
    public String addRoleConfirm(UserRoleBindingModel userRoleBindingModel) {
        this.userService.setRole(userRoleBindingModel.getUsername(), userRoleBindingModel.getRole());
        return "redirect:/home";
    }

    @GetMapping("add/exercise")
    public String addExercise(Model model) {
        if (!model.containsAttribute("exerciserBindingModel")) {
            model.addAttribute("exerciserBindingModel", new ExerciserBindingModel());
        }
        return "exercise-add";
    }

    @PostMapping("add/exercise")
    public String addExerciseConfirm(@Valid @ModelAttribute("exerciserBindingModel") ExerciserBindingModel exerciserBindingModel,
                                     BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("exerciserBindingModel", exerciserBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.exerciserBindingModel", bindingResult);
        }
this.exerciseService.add(modelMapper.map(exerciserBindingModel, ExerciseServiceModel.class));
        return "redirect:/home";
    }
}
