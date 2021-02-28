package com.example.mobilelele.services.impls;

import com.example.mobilelele.models.entities.Brand;
import com.example.mobilelele.models.entities.Model;
import com.example.mobilelele.models.view.BrandsOfferViewModel;
import com.example.mobilelele.models.view.BrandsViewModel;
import com.example.mobilelele.models.view.ModelViewModel;
import com.example.mobilelele.repositories.BrandRepository;
import com.example.mobilelele.services.BrandServices;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class BrandServicesImpl implements BrandServices {
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;
    private final Random random;

    public BrandServicesImpl(BrandRepository brandRepository, ModelMapper modelMapper, Random random) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
        this.random = random;
    }

    @Override
    public Brand findBrand(String name) {
        return this.brandRepository.findByName(name);
    }

    @Override
    public void createBrand(String name) {
        Brand brand = new Brand(name, LocalDateTime.now().minusDays(random.nextInt(1000)), LocalDateTime.now().minusDays(random.nextInt(1000)));
        this.brandRepository.saveAndFlush(brand);
    }

    @Override
    public List<BrandsViewModel> getAllBrands() {
        List<BrandsViewModel> brandsViewModels = new ArrayList<>();
        List<Brand> brands = this.brandRepository.findAll();
        brands.forEach(br -> {
            BrandsViewModel brandsViewModel = modelMapper.map(br, BrandsViewModel.class);
            brandsViewModel.setModel(new ArrayList<>());
            List<Model> models = br.getModels();
            models.forEach(m -> {
                ModelViewModel modelViewModel = modelMapper.map(m, ModelViewModel.class);

                brandsViewModel.getModel().add(modelViewModel);
            });
            brandsViewModels.add(brandsViewModel);
        });
        return brandsViewModels;
    }

    @Override
    public List<BrandsOfferViewModel> getBrandsAndModels() {
        List<BrandsOfferViewModel> brandsOffer = new ArrayList<>();
        List<Brand> brands = this.brandRepository.findAll();
        brands.forEach(b->{
            BrandsOfferViewModel bovm=new BrandsOfferViewModel();
            bovm.setName(b.getName());
            List<Model> models =b.getModels();
            List<String> modelNames= new ArrayList<>();
            models.forEach(m->{
                modelNames.add(m.getName());
            });
            bovm.setModel(modelNames);
            brandsOffer.add(bovm);
        });
        return brandsOffer;
    }

    @Override
    public boolean addBrand(String name) {
        if(brandRepository.findByName(name)==null){
            Brand brand= new Brand();
            brand.setName(name);
            brand.setModels(new ArrayList<>());
            brand.setCreated(LocalDateTime.now());
            brandRepository.saveAndFlush(brand);
            return true;
        }
        return false;
    }

    @Override
    public List<String> allBrands() {
        return this.brandRepository.findBrandNames();
    }
}
