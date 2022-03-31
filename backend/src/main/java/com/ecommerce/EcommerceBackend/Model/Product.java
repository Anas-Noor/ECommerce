package com.ecommerce.EcommerceBackend.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private double price;
//    @Column(name = "image")
//    @OneToMany(fetch= FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "productId")
//    @JsonManagedReference
//    @OneToMany()
//    @ElementCollection
//    @CollectionTable(name = "images")
//    private List<String> images = new ArrayList<>();
    private String image;

    @ManyToOne()
    private SubCategory subCategory;
    @ManyToMany
    private List<Varient> varients;
    @Column(name="stock")
    private Long stock;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", price=").append(price);
        sb.append(", image='").append(image).append('\'');
        sb.append(", subCategory=").append(subCategory);
        sb.append(", varients=").append(varients);
        sb.append(", stock=").append(stock);
        sb.append('}');
        return sb.toString();
    }
}
