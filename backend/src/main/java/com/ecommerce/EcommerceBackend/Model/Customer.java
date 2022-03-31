package com.ecommerce.EcommerceBackend.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private Integer password;
    private String fullName;
    private String billingAddress;
    private String default_shipping_address;
    private String country;
    private Integer phone;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", password=").append(password);
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", billingAddress='").append(billingAddress).append('\'');
        sb.append(", default_shipping_address='").append(default_shipping_address).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", phone=").append(phone);
        sb.append('}');
        return sb.toString();
    }
}
