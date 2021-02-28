package exam.services;

import exam.models.entities.User;
import exam.models.serviceModels.UserServiceModel;

public interface UserService {
    boolean registerUser(UserServiceModel map);

    boolean haveUser(String email, String password);

    User findByEmail(String username);
}
