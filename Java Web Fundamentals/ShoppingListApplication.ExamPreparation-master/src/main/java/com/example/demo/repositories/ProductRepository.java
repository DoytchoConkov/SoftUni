package com.example.demo.repositories;

import com.example.demo.models.entities.CategoryName;
import com.example.demo.models.entities.Product;
import com.example.demo.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select sum(p.price) from Product as p")
    BigDecimal findTotalPriceSum();

    List<Product> findAllByCategory_Name(CategoryName categoryName);

}
