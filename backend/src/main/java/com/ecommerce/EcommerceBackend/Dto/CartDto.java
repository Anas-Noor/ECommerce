package com.ecommerce.EcommerceBackend.Dto;

import com.ecommerce.EcommerceBackend.Model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private Long id;
    private List<Product> products;
    private Double amount;
}
