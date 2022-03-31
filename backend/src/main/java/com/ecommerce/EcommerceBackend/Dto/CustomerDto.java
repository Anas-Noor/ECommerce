package com.ecommerce.EcommerceBackend.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    private Long id;
    private String email;
    private Integer password;
    private String fullName;
    private String billingAddress;
    private String default_shipping_address;
    private String country;
    private Integer phone;
}
