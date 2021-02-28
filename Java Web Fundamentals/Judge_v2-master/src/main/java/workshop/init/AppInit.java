package workshop.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import workshop.services.RoleService;

@Component
public class AppInit implements CommandLineRunner {
 private final RoleService roleService;

    public AppInit(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.roleService.init();
    }
}
