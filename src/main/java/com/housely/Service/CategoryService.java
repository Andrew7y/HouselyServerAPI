package com.housely.Service;

import com.housely.Model.Category.Category;
import com.housely.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    // Injecting the CategoryRepository
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public Category findById(Long id){
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Category findByCategoryName(String categoryName){
        return categoryRepository.findByCategoryName(categoryName).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public List<Category> search(String keyword){
        return categoryRepository.search(keyword);
    }

    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }
}
