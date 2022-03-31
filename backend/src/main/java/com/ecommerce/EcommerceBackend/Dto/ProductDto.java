package com.ecommerce.EcommerceBackend.Dto;

import com.ecommerce.EcommerceBackend.Model.SubCategory;
import com.ecommerce.EcommerceBackend.Model.Varient;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.MultipleParentClassLoader;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
public class ProductDto {
    private String name;
    private String description;
    private Double price;
    private String image;
    private Long stock;
    private SubCategory subCategory;
    private List<Varient> varients;
    private MultipartFile multipart;

}
