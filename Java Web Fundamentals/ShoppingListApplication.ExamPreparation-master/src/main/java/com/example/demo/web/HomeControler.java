package com.example.demo.web;

import com.example.demo.models.entities.CategoryName;
import com.example.demo.models.security.CurrentUser;
import com.example.demo.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class HomeControler {
    private final ProductService productService;
    private final CurrentUser currentUser;

    public HomeControler(ProductService productService, CurrentUser currentUser) {
        this.productService = productService;
        this.currentUser = currentUser;
    }
    @GetMapping("/")
    public String index(Model model) {
        if(!currentUser.isAnonymous()){
            return "redirect:/home";
        }
        if(!model.containsAttribute("products")){
       //    List<Product> products = productService.allProducts();
//            model.addAttribute("products",products);
//            model.addAttribute("count",products.size());
        }
        return "index";
    }

    @GetMapping("home")
    public String home(Model model) {
        if(currentUser.isAnonymous()){
            return "redirect:/users/login";
        }
       model.addAttribute("totalPriceOfProducts",this.productService.getTotalSum());
       model.addAttribute("foods",this.productService.findByCategory(CategoryName.FOOD));
       model.addAttribute("drinks",this.productService.findByCategory(CategoryName.DRINK));
       model.addAttribute("household",this.productService.findByCategory(CategoryName.HOUSEHOLD));
       model.addAttribute("other",this.productService.findByCategory(CategoryName.OTHER));
        return "home";
    }

}
