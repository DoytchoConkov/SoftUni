package workshop.services.impl;

import org.springframework.stereotype.Service;
import workshop.models.entities.Role;
import workshop.models.entities.RoleName;
import workshop.repositories.RoleRepository;
import workshop.services.RoleService;

import java.util.Arrays;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void init() {
        if (roleRepository.count() == 0) {
            Arrays.stream(RoleName.values()).forEach(r -> {
                Role role = new Role(r);
                roleRepository.save(role);
            });
        }
    }

    @Override
    public Role admin() {
        return this.roleRepository.findByName(RoleName.ADMIN);
    }

    @Override
    public Role user() {
        return this.roleRepository.findByName(RoleName.USER);
    }

    @Override
    public Role getRole(RoleName role) {
        return this.roleRepository.findByName(role);
    }
}
