package com.example.mobilelele.repositories;

import com.example.mobilelele.models.entities.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles,Long> {
    Optional<UserRoles> findById(Long id);

}
