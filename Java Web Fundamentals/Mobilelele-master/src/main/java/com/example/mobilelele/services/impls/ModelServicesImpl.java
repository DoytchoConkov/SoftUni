package com.example.mobilelele.services.impls;

import com.example.mobilelele.models.dtos.ModelSeedDto;
import com.example.mobilelele.models.entities.Brand;
import com.example.mobilelele.models.entities.Model;
import com.example.mobilelele.models.view.ModelAddViewModel;
import com.example.mobilelele.repositories.ModelRepository;
import com.example.mobilelele.services.BrandServices;
import com.example.mobilelele.services.ModelServices;
import com.example.mobilelele.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

@Service
public class ModelServicesImpl implements ModelServices {
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;
    private final BrandServices brandServices;
    private final ValidationUtil validationUtil;
    private final Random random;

    public ModelServicesImpl(ModelMapper modelMapper, ModelRepository modelRepository, BrandServices brandServices, ValidationUtil validationUtil, Random random) {
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
        this.brandServices = brandServices;
        this.validationUtil = validationUtil;
        this.random = random;
    }

    @Override
    public void seedModels(ModelSeedDto[] dtos) {
        if (this.modelRepository.count() > 0) {
            return;
        }
        Arrays.stream(dtos).forEach(cln -> {
            if (this.validationUtil.isValid(cln)) {
                Model model = this.modelMapper.map(cln, Model.class);
                Brand brand = this.brandServices.findBrand(cln.getBrand());
                if (brand == null) {
                    this.brandServices.createBrand(cln.getBrand());
                }
                model.setBrand(this.brandServices.findBrand(cln.getBrand()));
                model.setCreated(LocalDateTime.now().minusDays(random.nextInt(1000)));
                model.setModified(LocalDateTime.now().minusDays(random.nextInt(1000)));
                this.modelRepository.saveAndFlush(model);
            } else {
                this.validationUtil.getViolations(cln)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        });
    }

    @Override
    public Model getModel(String name) {
        return this.modelRepository.findByName(name);
    }

    @Override
    public boolean addModel(ModelAddViewModel modelAddViewModel) {
        Model model = modelMapper.map(modelAddViewModel, Model.class);
        Brand brand = this.brandServices.findBrand(modelAddViewModel.getBrand());
        model.setBrand(brand);
        model.setCreated(LocalDateTime.now());
        this.modelRepository.saveAndFlush(model);
        return true;
    }


}
