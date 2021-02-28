package com.example.demo.repositories;

import com.example.demo.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryReposytory extends JpaRepository<Category, Long> {

}
