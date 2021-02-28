package com.example.exercises.services.impls;

import com.example.exercises.models.dtos.UserSeedDTO;
import com.example.exercises.models.entities.User;
import com.example.exercises.repositories.UserRepository;
import com.example.exercises.services.UserServices;
import com.example.exercises.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class UserServicesImpl implements UserServices {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public UserServicesImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void usersSeed(List<UserSeedDTO> userSeedDTOList) {
        userSeedDTOList.forEach(usr -> {
            if (this.validationUtil.isValid(usr)) {
                if (this.userRepository.findByLastName(usr.getLastName()) == null) {
                    User user = this.modelMapper.map(usr, User.class);
                    this.userRepository.saveAndFlush(user);
                } else {
                    System.out.println("DB have category with this name!");
                }
            } else {
                this.validationUtil
                        .getViolations(usr)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        });
    }

    @Override
    public User getRandomUser() {
        Random random = new Random();
        long id=random.nextInt((int) this.userRepository.count())+1;
        return this.userRepository.getOne(id);
    }


}
