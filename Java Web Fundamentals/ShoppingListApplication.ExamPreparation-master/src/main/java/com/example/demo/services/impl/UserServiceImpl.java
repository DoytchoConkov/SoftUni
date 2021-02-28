package com.example.demo.services.impl;

import com.example.demo.models.bindings.UserLoginBindingModel;
import com.example.demo.models.bindings.UserRegisterBindingModel;
import com.example.demo.models.entities.User;
import com.example.demo.models.security.CurrentUser;
import com.example.demo.models.services.UserServiceModel;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean registerUser(UserRegisterBindingModel userRegisterViewModel) {
        if (this.userRepository.findByUsername(userRegisterViewModel.getUsername()).isEmpty()) {
            User user = modelMapper.map(userRegisterViewModel, User.class);
            user.setPassword(passwordEncoder.encode(userRegisterViewModel.getPassword()));
            this.userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean haveUser(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isEmpty()) {
            return false;
        }
        if (passwordEncoder.matches(password, userOpt.get().getPassword())) {
            currentUser.setUsername(userOpt.get().getUsername());
            currentUser.setAnonymous(false);
            return true;
        }
        return false;

    }

}