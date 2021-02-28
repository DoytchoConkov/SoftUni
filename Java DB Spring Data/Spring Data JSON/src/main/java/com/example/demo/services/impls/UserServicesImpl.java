package com.example.demo.services.impls;

import com.example.demo.models.dtos.UserSeedDTO;
import com.example.demo.models.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserServices;
import com.example.demo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.util.Arrays;
import java.util.Random;

@Service
@Transactional
public class UserServicesImpl implements UserServices {
    private final UserRepository userRepo;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public UserServicesImpl(UserRepository userRepo, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedUsers(UserSeedDTO[] userSeedDTOS) {
        if (this.userRepo.count() > 0) {
            return;
        }
        Arrays.stream(userSeedDTOS).forEach(usr -> {
            if (this.validationUtil.isValid(usr)) {
                User user = this.modelMapper.map(usr, User.class);
                this.userRepo.saveAndFlush(user);
            } else {
                this.validationUtil.getViolations(usr)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        });
    }

    @Override
    public User getRandomUser() {
        Random random = new Random();
        long id=random.nextInt((int) this.userRepo.count())+1;
        return this.userRepo.getOne(id);
    }

}
