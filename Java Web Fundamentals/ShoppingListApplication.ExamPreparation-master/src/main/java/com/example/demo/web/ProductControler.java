package com.example.demo.web;

import com.example.demo.models.bindings.ProductAddBindingModel;
import com.example.demo.models.security.CurrentUser;
import com.example.demo.models.services.ProductServiceModel;
import com.example.demo.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductControler {
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final ProductService productService;

    public ProductControler(CurrentUser currentUser, ModelMapper modelMapper, ProductService productService) {
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.productService = productService;
    }

    @GetMapping("/add")
    public String add(Model model) {
        if (currentUser.isAnonymous()) {
            return "redirect:/users/login";
        }
        if (!model.containsAttribute("productAddBindingModel")) {
            model.addAttribute("productAddBindingModel", new ProductAddBindingModel());
        }
        return "product-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("productAddBindingModel") ProductAddBindingModel productAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (currentUser.isAnonymous()) {
            return "redirect:/users/login";
        }
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);
            return "redirect:add";
        }
        this.productService.addProduct(modelMapper.map(productAddBindingModel, ProductServiceModel.class));
        return "redirect:/home";
    }
    @GetMapping("/buy/all")
    public String buyAll(Model model) {
        if (currentUser.isAnonymous()) {
            return "redirect:/users/login";
        }
        this.productService.deleteAll();
        return "redirect:/home";
    }
    @GetMapping("/buy/{id}")
    public String buy(@PathVariable Long id, Model model) {
        if (currentUser.isAnonymous()) {
            return "redirect:/users/login";
        }
        this.productService.delete(id);
        return "redirect:/home";
    }
}
