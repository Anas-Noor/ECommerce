package com.ecommerce.EcommerceBackend.Dto;

import com.ecommerce.EcommerceBackend.Model.Cart;
import com.ecommerce.EcommerceBackend.Model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private String name;
    private Cart cart;
    private Customer customer;
}
