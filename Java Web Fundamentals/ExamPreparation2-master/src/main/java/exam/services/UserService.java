package exam.services;

import exam.models.bindings.UserLoginBindingModel;
import exam.models.service.UserServiceModel;

public interface UserService {
    boolean register(UserServiceModel userServiceModel);

    boolean isLogged(UserLoginBindingModel userLoginServiceModel);

    UserServiceModel findByUsername(String username);
}
