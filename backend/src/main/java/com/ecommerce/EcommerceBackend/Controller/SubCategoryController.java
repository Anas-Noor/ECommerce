package com.ecommerce.EcommerceBackend.Controller;

import com.ecommerce.EcommerceBackend.Dto.ProductDto;
import com.ecommerce.EcommerceBackend.Dto.SubCategoryDto;
import com.ecommerce.EcommerceBackend.Model.SubCategory;
import com.ecommerce.EcommerceBackend.Service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class SubCategoryController {
    @Autowired
    SubCategoryService subCategoryService;
    @GetMapping("/{categoryId}/subcategory")
    public List<SubCategory> getAllSubCategories(@PathVariable Long categoryId){
        return  subCategoryService.getAllSubCategories(categoryId);
    }
    @PostMapping("/{categoryId}/")
    public void addSubCategory(@PathVariable Long categoryId, @RequestBody SubCategoryDto subCategoryDto){
        subCategoryService.addSubCategory(categoryId,subCategoryDto);
    }
//    @PostMapping("/{id}")
//    public void addSubCategory(@PathVariable Long id,@RequestBody ProductDto productDto){
//        subCategoryService.addProductInSubCategory(id,productDto);
//    }

        @PutMapping("/subcategory/{id}")
    public void updateSubCategory(@PathVariable Long id, @RequestBody SubCategoryDto subCategoryDto){
        subCategoryService.updateSubCategory(id,subCategoryDto);
    }
    @DeleteMapping("/subcategory/{id}")
    public void deleteSubCategoryById(@PathVariable Long id){
        subCategoryService.deleteSubCategoryById(id);
    }
    @GetMapping("/subcategory/{id}")
    public SubCategory findSubCategoryById(@PathVariable Long id) {
        return subCategoryService.findSubCategoryById(id);
    }
//    @DeleteMapping("/")
//    public void deleteAllSubCategory(){
//        subCategoryService.deleteAllSubCategory();
//    }


}
