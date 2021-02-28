package exam.web;

import exam.models.bindings.ItemAddBindingModel;
import exam.models.service.ItemServiceModel;
import exam.services.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/items")
public class ItemControler {
    private final ItemService itemService;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public ItemControler(ItemService itemService, ModelMapper modelMapper, HttpSession httpSession) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @GetMapping("/add")
    public String add(Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        if (!model.containsAttribute("itemAddBindingModel")) {
            model.addAttribute("itemAddBindingModel", new ItemAddBindingModel());
        }
        return "add-item";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("itemAddBindingModel") ItemAddBindingModel itemAddBindingModel, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("itemBindingModel", itemAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.itemAddBindingModel", bindingResult);
            return "redirect:add";
        }
        ItemServiceModel itemServiceModel=this.modelMapper.map(itemAddBindingModel, ItemServiceModel.class);
        this.itemService.addItem(itemServiceModel);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable String id, ModelAndView modelAndView){
        if (httpSession.getAttribute("user") == null) {
            modelAndView.setViewName("redirect:/users/login");
            return modelAndView;
        }
        modelAndView.setViewName("details-item");
        modelAndView.addObject("item", this.itemService.findById(id));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        if (httpSession.getAttribute("user") == null) {
            return "redirect:users/login";
        }
        this.itemService.delete(id);
        return "redirect:/";
    }

}
