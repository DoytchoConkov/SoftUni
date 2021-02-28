package exam.web;

import exam.models.security.CurrentUser;
import exam.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeControler {
    private final CurrentUser currentUser;
    private final TaskService taskService;

    public HomeControler(CurrentUser currentUser, TaskService taskService) {
        this.currentUser = currentUser;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index(Model model) {
        if (!currentUser.isAnonymous()) {
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("home")
    public String home(Model model) {
        if (currentUser.isAnonymous()) {
            return "redirect:/users/login";
        }
        model.addAttribute("taskViewModels", this.taskService.viewAll());
        return "home";
    }
}