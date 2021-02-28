package com.example.mobilelele.repositories;

import com.example.mobilelele.models.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    public Brand findByName(String name);

    @Query("SELECT b.name from Brand as b")
    List<String> findBrandNames();

}
