package com.example.mobilelele.services;

import com.example.mobilelele.models.entities.Offer;
import com.example.mobilelele.models.view.OfferAddViewModel;
import com.example.mobilelele.models.view.OfferDetailsViewModel;
import com.example.mobilelele.models.view.OfferViewModel;

import java.util.List;

public interface OfferServices {
    void saveOffer(Offer offer);

    List<OfferViewModel> getAll();

    OfferDetailsViewModel getOfferById(Long id);

    void deleteOfferById(Long id);

    void updateOffer(OfferAddViewModel offerAddViewModel);
}
