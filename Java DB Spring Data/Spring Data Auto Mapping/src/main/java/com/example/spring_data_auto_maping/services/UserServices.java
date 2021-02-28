package com.example.spring_data_auto_maping.services;

import com.example.spring_data_auto_maping.domains.DTOs.UserLoginDTO;
import com.example.spring_data_auto_maping.domains.DTOs.UserRegisteredDTO;
import com.example.spring_data_auto_maping.domains.entities.Game;

import java.util.List;

public interface UserServices {

    void registerUser(UserRegisteredDTO  userRegisteredDTO);

    void loginUser(UserLoginDTO userLoginDTO);

    void logoutUser();
    boolean isLoggedUserIsAdmin();
    void userGames();
}
