package exam.web;

import exam.models.bindingModels.TaskBindingModel;
import exam.models.security.CurrentUser;
import exam.services.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskControler {
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final TaskService taskService;

    public TaskControler(CurrentUser currentUser, ModelMapper modelMapper, TaskService taskService) {
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.taskService = taskService;
    }

    @GetMapping("/add")
    public String addTask(Model model) {
        if (currentUser.isAnonymous()) {
            return "redirect:/users/login";
        }
        if (!model.containsAttribute("taskBindingModel")) {
            model.addAttribute("taskBindingModel", new TaskBindingModel());
        }
        return "add-task";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("taskBindingModel") TaskBindingModel taskBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (currentUser.isAnonymous()) {
            return "redirect:/users/login";
        }
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("taskBindingModel", taskBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskBindingModel", bindingResult);
            return "redirect:add";
        }
        this.taskService.addTask(taskBindingModel);
        return "redirect:/home";
    }

    @GetMapping("/progress/{id}")
    public String addTask(@PathVariable Long id, Model model) {
        if (currentUser.isAnonymous()) {
            return "redirect:/users/login";
        }

        this.taskService.updateTask(id);

        return "redirect:/";
    }

}
