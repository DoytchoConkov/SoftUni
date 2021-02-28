package com.example.demo.services;

import com.example.demo.models.bindings.UserLoginBindingModel;
import com.example.demo.models.bindings.UserRegisterBindingModel;
import com.example.demo.models.services.UserServiceModel;

public interface UserService {
    boolean registerUser(UserRegisterBindingModel userModel);
    boolean haveUser(String username,String password);

}
