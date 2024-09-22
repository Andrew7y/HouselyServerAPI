package com.housely.Repository;

import com.housely.Model.Category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCategoryName(String categoryName);

    @Query("SELECT c FROM Category c WHERE c.categoryName LIKE %?1%")
    List<Category> search(String keyword);

}
