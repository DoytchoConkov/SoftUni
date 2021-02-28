package com.example.demo.services;

import com.example.demo.models.dtos.UserSeedDTO;
import com.example.demo.models.entities.User;

public interface UserServices {
    void seedUsers(UserSeedDTO[] userSeedDTOS);

    User getRandomUser();
}
