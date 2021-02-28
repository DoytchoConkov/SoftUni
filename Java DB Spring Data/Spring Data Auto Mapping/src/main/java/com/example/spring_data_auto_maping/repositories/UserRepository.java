package com.example.spring_data_auto_maping.repositories;

import com.example.spring_data_auto_maping.domains.entities.Game;
import com.example.spring_data_auto_maping.domains.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    User findByEmailAndPassword(String email,String password);
User findUserByEmail(String email);
}
