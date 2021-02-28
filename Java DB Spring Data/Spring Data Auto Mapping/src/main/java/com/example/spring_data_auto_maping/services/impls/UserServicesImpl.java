package com.example.spring_data_auto_maping.services.impls;

import com.example.spring_data_auto_maping.domains.DTOs.UserDTO;
import com.example.spring_data_auto_maping.domains.DTOs.UserLoginDTO;
import com.example.spring_data_auto_maping.domains.DTOs.UserRegisteredDTO;
import com.example.spring_data_auto_maping.domains.entities.Game;
import com.example.spring_data_auto_maping.domains.entities.Role;
import com.example.spring_data_auto_maping.domains.entities.User;
import com.example.spring_data_auto_maping.repositories.UserRepository;
import com.example.spring_data_auto_maping.services.UserServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImpl implements UserServices {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private UserDTO userDTO;

    @Autowired
    public UserServicesImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserRegisteredDTO userRegisteredDTO) {
        User user = this.modelMapper.map(userRegisteredDTO, User.class);
        user.setRole(this.userRepository.count() == 0 ? Role.ADMIN : Role.USER);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public void loginUser(UserLoginDTO userLoginDTO) {
        User user = this.userRepository.findByEmailAndPassword(userLoginDTO.getEmail(),userLoginDTO.getPassword());
        if (user == null) {
            System.out.println("Incorrect username / password");
        } else {
            this.userDTO = this.modelMapper.map(user, UserDTO.class);
            System.out.printf("Successfully logged in %s%n",user.getFullName());
        }
    }

    @Override
    public void logoutUser() {

        if (this.userDTO==null){
            System.out.println("Cannot log out. No user was logged in.");
        }else{
            String userFullname = this.userDTO.getFullName();
            this.userDTO = null;
            System.out.printf("User %s successfully logged out%n",userFullname);
        }
    }

    @Override
    public boolean isLoggedUserIsAdmin() {
        if (this.userDTO==null){
            return false;
        }
        return this.userDTO.getRole().equals(Role.ADMIN);
    }

    @Override
    public void userGames() {
        if (this.userDTO==null){
            System.out.println("No logged user!");
            return;
        }
        List<Game> games = this.userRepository.findUserByEmail(this.userDTO.getEmail()).getGames();
        games.forEach(g-> System.out.printf("%s%n",g.getTitle()));
    }
}
