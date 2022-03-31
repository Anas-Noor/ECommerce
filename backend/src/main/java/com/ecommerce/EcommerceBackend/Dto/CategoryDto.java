package com.ecommerce.EcommerceBackend.Dto;

import com.ecommerce.EcommerceBackend.Model.SubCategory;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;
@Setter
@Getter

public class CategoryDto {
    private Long id;
    private String name;
    private String thumbnail;

}
