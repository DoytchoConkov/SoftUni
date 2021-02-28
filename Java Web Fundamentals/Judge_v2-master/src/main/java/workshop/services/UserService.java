package workshop.services;

import workshop.models.bindingModels.UserLoginBindingModel;
import workshop.models.entities.RoleName;
import workshop.models.entities.User;
import workshop.models.services.UserServiceModel;
import workshop.models.view.UserViewModel;

import java.util.List;

public interface UserService {
    boolean register(UserServiceModel map);

    boolean isLogged(UserLoginBindingModel userLoginBindingModel);

    UserServiceModel findByUsername(String username);

    RoleName getRole(String username);

    UserViewModel findUserProfile(String username);

    List<UserViewModel> allUsers();

    void setRole(String username, RoleName role);

    User getCurrentUser();
}

