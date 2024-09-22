package com.housely.Controller;

import com.housely.Model.Category.Category;
import com.housely.Model.Product.Product;
import com.housely.Service.CategoryService;
import com.housely.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        if(productService.findAll().isEmpty()){
            return new ResponseEntity<>("No products", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

//    @GetMapping("/products/{productId}")

    @GetMapping("/{categoryName}/products")
    public ResponseEntity<?> getProductsByCategoryName(@PathVariable String categoryName) {
        try{
            categoryService.findByCategoryName(categoryName);
            return new ResponseEntity<>(productService.findByCategoryName(categoryName), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{categoryName}/products/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable String categoryName, @PathVariable String productId) {
        try{
            categoryService.findByCategoryName(categoryName);
            return new ResponseEntity<>(productService.findById(productId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{categoryName}/products")
    public ResponseEntity<?> addProduct(@RequestBody Product product, @PathVariable String categoryName) {
        try{
            Category category = categoryService.findByCategoryName(categoryName);
            product.getCategories().add(category);
            category.getProductInCategories().add(product);
            return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{categoryName}/products/{productId}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable String categoryName, @PathVariable String productId) {
        try{
            Category category = categoryService.findByCategoryName(categoryName);
            product.getCategories().add(category);
            product.setProductCode(productId);
            category.getProductInCategories().add(product);
            return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{categoryName}/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable String categoryName, @PathVariable String productId) {
        try{
            Category category = categoryService.findByCategoryName(categoryName);
            Product product = productService.findById(productId);
            category.getProductInCategories().remove(product);
            productService.deleteById(productId);
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }




}
