package com.housely.Repository;

import com.housely.Model.Category.Category;
import com.housely.Model.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT p FROM Product p JOIN p.categories c WHERE c.categoryName = :categoryName")
    List<Product> findByCategoryName(@Param("categoryName") String categoryName);
}
