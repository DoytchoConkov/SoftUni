package workshop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import workshop.models.bindingModels.UserLoginBindingModel;
import workshop.models.entities.Role;
import workshop.models.entities.RoleName;
import workshop.models.entities.User;
import workshop.models.services.UserServiceModel;
import workshop.models.view.UserViewModel;
import workshop.repositories.UserRepository;
import workshop.services.RoleService;
import workshop.services.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final RoleService roleService;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public UserServiceImpl(RoleService roleService, UserRepository userRepository, ModelMapper modelMapper, HttpSession httpSession) {
        this.roleService = roleService;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @Override
    public boolean register(UserServiceModel userServiceModel) {
        if (userRepository.findByUsername(userServiceModel.getUsername()).orElse(null) == null) {
            User user = modelMapper.map(userServiceModel, User.class);
            if (userRepository.count() == 0) {
                Role role = roleService.admin();
                user.setRole(role);
            } else {
                Role role = roleService.user();
                user.setRole(role);
            }
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean isLogged(UserLoginBindingModel userLoginBindingModel) {
        User user = userRepository.findByUsername(userLoginBindingModel.getUsername()).orElse(null);
        if (user != null) {
            if (user.getPassword().equals(userLoginBindingModel.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public UserServiceModel findByUsername(String username) {
        User user = this.userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            UserServiceModel userService = modelMapper.map(user, UserServiceModel.class);
            if (user.getRole().equals(this.roleService.admin())) {
                userService.setAdmin(true);
            } else {
                userService.setAdmin(false);
            }
            return userService;
        }
        return null;
    }

    @Override
    public RoleName getRole(String username) {
        return this.userRepository.findRoleByUsername(username);
    }

    @Override
    public UserViewModel findUserProfile(String username) {
        Optional<User> user = this.userRepository.findByUsername(username);
        UserViewModel userViewModel = modelMapper.map(user.orElse(null), UserViewModel.class);
        return userViewModel;
    }

    @Override
    public List<UserViewModel> allUsers() {
        return this.userRepository.findAll().stream().map(u->modelMapper.map(u,UserViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public void setRole(String username, RoleName role) {
        User user = this.userRepository.findByUsername(username).orElse(null);
        user.setRole(this.roleService.getRole(role));
        this.userRepository.save(user);
    }

    @Override
    public User getCurrentUser() {
        UserServiceModel user = (UserServiceModel) httpSession.getAttribute("user");
        if(user!=null){
           return this.userRepository.findByUsername(user.getUsername()).orElse(null);
        }
        return null;
    }
}
