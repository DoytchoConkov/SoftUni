package com.example.mobilelele.web;

import com.example.mobilelele.models.view.BrandsViewModel;
import com.example.mobilelele.services.BrandServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/brands")
public class BrandsController {
    private final BrandServices brandServices;

    public BrandsController(BrandServices brandServices) {
        this.brandServices = brandServices;
    }

    @GetMapping("all")
    public String viewAllBrands(Model model) {
        List<BrandsViewModel> brandsViewModelList = this.brandServices.getAllBrands();
        model.addAttribute("brands",brandsViewModelList);
        return  "brands";
    }

}
