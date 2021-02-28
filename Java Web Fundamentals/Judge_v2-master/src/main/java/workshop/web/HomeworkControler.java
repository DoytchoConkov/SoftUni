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
import workshop.models.bindingModels.HomeworkBindingModel;
import workshop.models.entities.User;
import workshop.models.services.HomeworkServiceModel;
import workshop.services.ExerciseService;
import workshop.services.HomeworkService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("homeworks/")
public class HomeworkControler {
    private final ExerciseService exerciseService;
    private final ModelMapper modelMapper;
    private final HomeworkService homeworkService;
    private final HttpSession httpSession;

    public HomeworkControler(ExerciseService exerciseService, ModelMapper modelMapper, HomeworkService homeworkService, HttpSession httpSession) {
        this.exerciseService = exerciseService;
        this.modelMapper = modelMapper;
        this.homeworkService = homeworkService;
        this.httpSession = httpSession;
    }

    @GetMapping("/add")
    public String addHomework(Model model) {
        if (!model.containsAttribute("homeworkBindingModel")) {
            model.addAttribute("homeworkBindingModel", new HomeworkBindingModel());
        }
        model.addAttribute("exercises", this.exerciseService.getAll());
        return "homework-add";
    }

    @PostMapping("/add")
    public String addHomeworkConfirm(@Valid @ModelAttribute("homeworkBindingModel") HomeworkBindingModel homeworkBindingModel,
                                     BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "homework-add";
        }
        homeworkBindingModel.setAddedOn(LocalDateTime.now());
        this.homeworkService.add(modelMapper.map(homeworkBindingModel, HomeworkServiceModel.class));
        return "home";
    }

    @GetMapping("/check")
    public String checkHomework() {
        return "homework-check";
    }

}
