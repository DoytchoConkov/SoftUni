package com.example.mobilelele.services;


import com.example.mobilelele.models.entities.User;
import com.example.mobilelele.models.view.UserRegisterViewModel;
import com.example.mobilelele.models.view.UserRoleSetServiceModel;

import java.util.List;

public interface UserServices {
  boolean haveUser(String username,String password);
  boolean registerUser(UserRegisterViewModel userRegisterViewModel);

    List<String> getUsers();

    void setRole(UserRoleSetServiceModel userRoleSetServiceModel);
}

