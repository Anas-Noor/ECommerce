package com.ecommerce.EcommerceBackend.Repository;

import com.ecommerce.EcommerceBackend.Model.Category;
import com.ecommerce.EcommerceBackend.Model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {


   @Query(value = "select * from sub_category where sub_category.category_id = :categoryId",nativeQuery = true)
   public List<SubCategory> getSubCategoriesByCategoryId(Long categoryId);
}
