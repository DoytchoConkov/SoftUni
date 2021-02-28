package com.example.mobilelele.web;

import com.example.mobilelele.models.view.OfferAddViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeControler {
    @GetMapping("/")
    public ModelAndView addOfferPage(@ModelAttribute OfferAddViewModel offerAddViewModel) {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}
