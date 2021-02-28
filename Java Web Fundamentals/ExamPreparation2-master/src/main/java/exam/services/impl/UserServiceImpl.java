package exam.services.impl;

import exam.models.bindings.UserLoginBindingModel;
import exam.models.entities.User;
import exam.models.service.UserServiceModel;
import exam.repositories.UserRepository;
import exam.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean register(UserServiceModel userServiceModel) {
        if (userRepository.findByUsername(userServiceModel.getUsername()).orElse(null) == null) {
            User user = modelMapper.map(userServiceModel, User.class);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean isLogged(UserLoginBindingModel userLoginBindingModel) {
        User user = userRepository.findByUsername(userLoginBindingModel.getUsername()).orElse(null);
        if (user!=null){
            if (user.getPassword().equals(userLoginBindingModel.getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public UserServiceModel findByUsername(String username) {
        return this.userRepository.findByUsername(username).map(usr->this.modelMapper.map(usr,UserServiceModel.class)).orElse(null);
    }
}
