package com.ecommerce.EcommerceBackend.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Varient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String varientName;
//    @ManyToMany
//    private Product product;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Varient{");
        sb.append("id=").append(id);
        sb.append(", varientName='").append(varientName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
