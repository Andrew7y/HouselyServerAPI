package com.housely.Repository;

import com.housely.Model.Category.Category;
import com.housely.Model.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT p FROM Product p JOIN p.categories c WHERE c.categoryName = :categoryName")
    List<Product> findByCategoryName(@Param("categoryName") String categoryName);

    @Query("SELECT p.categories FROM Product p WHERE p.productCode = :productCode")
    List<Category> findCategoriesByProductCode(@Param("productCode") String productCode);

    @Query("SELECT p FROM Product p JOIN p.rooms r WHERE r.id = :roomId")
    List<Product> findByRoomId(@Param("roomId") Long roomId);
}
