package com.ecommerce.EcommerceBackend.Controller;

import com.ecommerce.EcommerceBackend.Dto.CategoryDto;
import com.ecommerce.EcommerceBackend.Model.Category;
import com.ecommerce.EcommerceBackend.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public List<Category> getAllCategories(){
        return  categoryService.getAllCategories();
    }
    @PostMapping()
    public void addCategory(@RequestBody CategoryDto categoryDto){
        categoryService.addCategory(categoryDto);
    }
    @PutMapping("/{id}")
    public void updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto){
        categoryService.updateUser(id,categoryDto);
    }
    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }
//    @PostMapping("/{categoryId}/subcategory/{subCategoryId}")
//    public void addSubcategoryById(@PathVariable Long categoryId,@PathVariable Long subCategoryId){
//        categoryService.addSubCategoryById(subCategoryId,categoryId);
//    }
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
    }
//    @DeleteMapping("/")
//    public void deleteAllCategory(){
//        categoryService.deleteAllCategory();
//    }


}
