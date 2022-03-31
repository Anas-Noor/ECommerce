package com.ecommerce.EcommerceBackend.Service;

import com.ecommerce.EcommerceBackend.Dto.CategoryDto;
import com.ecommerce.EcommerceBackend.Model.Category;
import com.ecommerce.EcommerceBackend.Repository.CategoryRepository;
//import com.ecommerce.EcommerceBackend.Repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

//    public void addSubCategoryById(Long subCategoryId,Long categoryId){
//        SubCategory subCategory = subCategoryRepository.findAll().stream().filter(x -> Long.valueOf(x.getId()) == subCategoryId).findAny().get();
//    }

    public void addCategory(CategoryDto category){
        Category category1=new Category();
        category1.setName(category.getName());
        category1.setId(category.getId());
        category1.setThumbnail(category.getThumbnail());
        categoryRepository.save(category1);
    }

    public void updateUser(Long id, CategoryDto categoryDto) {
        Category category = getCategoryById(id).orElseThrow(null);
        category.setId(id);
        category.setName(categoryDto.getName());
        category.setThumbnail(categoryDto.getThumbnail());
        categoryRepository.save(category);
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.delete(categoryRepository.findAll().stream().filter(c -> Long.valueOf(c.getId()) == id).findAny().get());
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
//
//    public void deleteCategoryById(Long id){
//        categoryRepository.delete(categoryRepository.findAll().stream().filter(c -> Long.valueOf(c.getId()) == id).findAny().get());
//    }
//    public void deleteAllCategory(){
//        categoryRepository.deleteAll();
//    }
}
