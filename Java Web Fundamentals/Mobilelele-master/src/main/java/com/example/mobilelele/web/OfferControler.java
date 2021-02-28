package com.example.mobilelele.web;

import com.example.mobilelele.models.entities.Engine;
import com.example.mobilelele.models.entities.Offer;
import com.example.mobilelele.models.entities.Transmission;
import com.example.mobilelele.models.view.BrandsOfferViewModel;
import com.example.mobilelele.models.view.OfferAddViewModel;
import com.example.mobilelele.models.view.OfferDetailsViewModel;
import com.example.mobilelele.models.view.OfferViewModel;
import com.example.mobilelele.services.BrandServices;
import com.example.mobilelele.services.ModelServices;
import com.example.mobilelele.services.OfferServices;
import com.example.mobilelele.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/offers")
public class OfferControler {
    private final ModelMapper modelMapper;
    private final BrandServices brandServices;
    private final ModelServices modelServices;
    private final OfferServices offerServices;
    private final ValidationUtil validationUtil;

    public OfferControler(ModelMapper modelMapper, BrandServices brandServices, ModelServices modelServices,
                          OfferServices offerServices, ValidationUtil validationUtil) {
        this.modelMapper = modelMapper;
        this.brandServices = brandServices;
        this.modelServices = modelServices;
        this.offerServices = offerServices;
        this.validationUtil = validationUtil;
    }

    @GetMapping("/add")
    public ModelAndView addOfferView(@ModelAttribute OfferAddViewModel offerAddViewModel) {
        List<String> engines = Stream.of(Engine.values()).map(Enum::name).collect(Collectors.toList());
        List<String> transmissions = Stream.of(Transmission.values()).map(Enum::name).collect(Collectors
                .toList());
        List<BrandsOfferViewModel> brands = this.brandServices.getBrandsAndModels();
        ModelAndView modelAndView = new ModelAndView("offer-add.html");
        modelAndView.addObject("engines", engines);
        modelAndView.addObject("transmissions", transmissions);
        modelAndView.addObject("brands", brands);

        return modelAndView;
    }

    @PostMapping("/add")
    public String addOffer(@ModelAttribute OfferAddViewModel offerAddViewModel) {
        if(!validationUtil.isValid(offerAddViewModel)){
            return "redirect:/users/add";
        }
        Offer offer = modelMapper.map(offerAddViewModel, Offer.class);
        offer.setModel(modelServices.getModel(offerAddViewModel.getModel()));
        offer.setCreated(LocalDateTime.now());
        offer.setModified(LocalDateTime.now());
        this.offerServices.saveOffer(offer);
        return "redirect:/";
    }

    @GetMapping("/all")
    public ModelAndView viewAllOffers() {
        List<OfferViewModel> offerViewModels = this.offerServices.getAll();
        ModelAndView modelAndView = new ModelAndView("offers.html");
        modelAndView.addObject("offers", offerViewModels);
        return modelAndView;
    }

    @GetMapping("/info/{id}")
    public ModelAndView detailsOffer(@PathVariable("id") Long id) {
        OfferDetailsViewModel offerDetailsViewModel = this.offerServices.getOfferById(id);
        ModelAndView modelAndView = new ModelAndView("details.html");
        modelAndView.addObject("offer", offerDetailsViewModel);
        return modelAndView;
    }
    @GetMapping("/update/{id}")
    public ModelAndView editOfferView(@PathVariable("id") Long id ,
                                      @ModelAttribute OfferAddViewModel offerAddViewModel) {
        OfferDetailsViewModel offerDetailsViewModel = this.offerServices.getOfferById(id);
        ModelAndView modelAndView = new ModelAndView("update.html");
        modelAndView.addObject("offer", offerDetailsViewModel);
        List<String> engines = Stream.of(Engine.values()).map(Enum::name).collect(Collectors.toList());
        List<String> transmissions = Stream.of(Transmission.values()).map(Enum::name).collect(Collectors
                .toList());
        List<BrandsOfferViewModel> brands = this.brandServices.getBrandsAndModels();
        modelAndView.addObject("engines", engines);
        modelAndView.addObject("transmissions", transmissions);
        modelAndView.addObject("brands", brands);
        return modelAndView;
    }
    @PostMapping("/update/{id}")
    public String updateOffer(@PathVariable Long id, @Valid @ModelAttribute OfferAddViewModel offerAddViewModel,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userModel", offerAddViewModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerAddViewModel",
                    bindingResult);
            return "redirect:/offers/update/{id}";
        }
        this.offerServices.updateOffer(offerAddViewModel);
        return "redirect:/offers/all";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView deleteOffer(@PathVariable("id") Long id) {
        this.offerServices.deleteOfferById(id);
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}
