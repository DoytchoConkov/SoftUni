package workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import workshop.models.entities.RoleName;
import workshop.models.entities.User;
import workshop.models.view.UserViewModel;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);

    @Query("select u.role from User as u")
    RoleName findRoleByUsername(String username);

}
