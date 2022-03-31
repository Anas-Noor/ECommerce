package com.ecommerce.EcommerceBackend.Model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;
    private String thumbnail;
//
//    @Column(name = "image")
//    private String image;

//    @OneToMany(mappedBy = "category")
//    @JoinColumn(name = "sub_category")
//    private List<SubCategory> subCategories;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Category{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", thumbnail='").append(thumbnail).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
