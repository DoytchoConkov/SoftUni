package com.example.mobilelele.services.impls;

import com.example.mobilelele.models.entities.Roles;
import com.example.mobilelele.models.entities.User;
import com.example.mobilelele.models.entities.UserRoles;
import com.example.mobilelele.models.security.CurrentUser;
import com.example.mobilelele.models.view.UserRegisterViewModel;
import com.example.mobilelele.models.view.UserRoleSetServiceModel;
import com.example.mobilelele.repositories.UserRepository;
import com.example.mobilelele.services.UserRolesService;
import com.example.mobilelele.services.UserServices;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServicesImpl implements UserServices {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final UserRolesService userRolesService;

    public UserServicesImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser, ModelMapper modelMapper, UserRolesService userRolesService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.userRolesService = userRolesService;
    }

    @Override
    public boolean haveUser(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isEmpty()) {
            return false;
        } else {
            if (passwordEncoder.matches(password, userOpt.get().getPassword())) {
                currentUser.setUsername(userOpt.get().getUsername());
                currentUser.setAnonymous(false);
                List<Roles> roles = userOpt.get().getRole().stream().map(ur->ur.getRole()).collect(Collectors.toList());
                currentUser.setRoles(roles);
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean registerUser(UserRegisterViewModel userRegisterViewModel) {
        if (this.userRepository.findByUsername(userRegisterViewModel.getUsername()).isEmpty()) {
            User user = modelMapper.map(userRegisterViewModel, User.class);
            user.setPassword(passwordEncoder.encode(userRegisterViewModel.getPassword()));
            if (this.userRepository.count() == 0) {
            user.setRole(List.of(userRolesService.getRole(1L)));

            } else {
                user.setRole(List.of(userRolesService.getRole(2L)));
            }
            user.setCreated(LocalDateTime.now());
            this.userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public List<String> getUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public void setRole(UserRoleSetServiceModel userRoleSetServiceModel) {
        User user = this.userRepository.findByUsername(userRoleSetServiceModel.getUsername()).orElse(null);
        user.getRole().clear();
        user.getRole().add(userRolesService.findRole(userRoleSetServiceModel.getAdmin()));
        user.getRole().add(userRolesService.findRole(userRoleSetServiceModel.getAdmin()));
    }
}
