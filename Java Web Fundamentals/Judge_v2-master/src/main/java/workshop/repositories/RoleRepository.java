package workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import workshop.models.entities.Role;
import workshop.models.entities.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
    Role findByName(RoleName name);
}
