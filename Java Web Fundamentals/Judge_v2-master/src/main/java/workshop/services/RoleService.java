package workshop.services;

import workshop.models.entities.Role;
import workshop.models.entities.RoleName;

public interface RoleService {
    void init();

    Role admin();

    Role user();

    Role getRole(RoleName role);
}
