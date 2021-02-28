package com.example.exercises.services;

import com.example.exercises.models.dtos.UserSeedDTO;
import com.example.exercises.models.entities.User;

import java.util.List;

public interface UserServices {

    void usersSeed(List<UserSeedDTO> userSeedDTOList);
    User getRandomUser();
}
