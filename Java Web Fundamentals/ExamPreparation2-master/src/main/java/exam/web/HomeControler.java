package exam.web;

import exam.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeControler {
    private final ItemService itemService;
    private final HttpSession httpSession;

    public HomeControler(ItemService itemService, HttpSession httpSession) {
        this.itemService = itemService;
        this.httpSession = httpSession;
    }

    @GetMapping("")
    public ModelAndView index(ModelAndView modelAndView) {
        if (httpSession.getAttribute("user") == null) {
            modelAndView.setViewName("index");
        } else {
            modelAndView.addObject("items", this.itemService.allItems());
            modelAndView.setViewName("home");
        }
        return modelAndView;
    }

    @GetMapping("/home")
    public String home() {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:users/login";
        }
        return "home";
    }
}
