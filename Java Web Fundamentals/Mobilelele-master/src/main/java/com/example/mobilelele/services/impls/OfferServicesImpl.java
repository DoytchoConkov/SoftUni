package com.example.mobilelele.services.impls;

import com.example.mobilelele.models.entities.Offer;
import com.example.mobilelele.models.view.OfferAddViewModel;
import com.example.mobilelele.models.view.OfferDetailsViewModel;
import com.example.mobilelele.models.view.OfferViewModel;
import com.example.mobilelele.repositories.OfferRepository;
import com.example.mobilelele.services.BrandServices;
import com.example.mobilelele.services.ModelServices;
import com.example.mobilelele.services.OfferServices;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OfferServicesImpl implements OfferServices {
    private final OfferRepository offerRepository;
    private final ModelServices modelServices;
    private final ModelMapper modelMapper;

    public OfferServicesImpl(OfferRepository offerRepository, ModelServices modelServices, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelServices = modelServices;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveOffer(Offer offer) {
        this.offerRepository.saveAndFlush(offer);
    }

    @Override
    public List<OfferViewModel> getAll() {
        List<OfferViewModel> offersView = new ArrayList<>();
        List<Offer> offers = this.offerRepository.findAll();
        offers.forEach(o -> {
            OfferViewModel offer = modelMapper.map(o, OfferViewModel.class);
            offer.setModel(o.getModel().getName());
            offer.setBrand(o.getModel().getBrand().getName());
            offersView.add(offer);
        });
        return offersView;
    }

    @Override
    public OfferDetailsViewModel getOfferById(Long id) {
        Optional<Offer> offer = this.offerRepository.findById(id);
        OfferDetailsViewModel offerDetailsViewModel = modelMapper.map(offer.get(), OfferDetailsViewModel.class);
        offerDetailsViewModel.setModel(offer.get().getModel().getName());
        offerDetailsViewModel.setBrand(offer.get().getModel().getBrand().getName());
        return offerDetailsViewModel;
    }

    @Override
    public void deleteOfferById(Long id) {
        this.offerRepository.deleteById(id);
    }

    @Override
    public void updateOffer(OfferAddViewModel offerAddViewModel) {
        Offer offer = modelMapper.map(offerAddViewModel, Offer.class);
        offer.setModel(modelServices.getModel(offerAddViewModel.getModel()));
        offer.setCreated(LocalDateTime.now());
        offer.setModified(LocalDateTime.now());
        this.offerRepository.save(offer);
    }
}
