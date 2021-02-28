package com.example.demo.repositories;

import com.example.demo.models.entities.Product;
import com.example.demo.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceBetweenAndBuyerIsNull(BigDecimal lower, BigDecimal higher);

    @Query("SELECT p FROM Product AS p WHERE p.buyer  IS NOT NULL ORDER BY p.seller.lastName ,p.seller.firstName")
    List<Product> findAllByBuyerOrderBySellerDesc();
    Product findBySeller(User seller);

}
