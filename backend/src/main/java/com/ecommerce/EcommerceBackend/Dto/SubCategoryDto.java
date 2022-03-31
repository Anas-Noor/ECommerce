package com.ecommerce.EcommerceBackend.Dto;

import com.ecommerce.EcommerceBackend.Model.Category;
import com.ecommerce.EcommerceBackend.Model.SubCategory;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
public class SubCategoryDto {

    private Long id;
    private String name;
    public Category category;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SubCategoryDto{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", category=").append(category);
        sb.append('}');
        return sb.toString();
    }
}
