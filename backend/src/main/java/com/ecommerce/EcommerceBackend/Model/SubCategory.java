package com.ecommerce.EcommerceBackend.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sub_category")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

//    @Column(name = "name", unique = true, nullable = false)
    private String name;

//    @OneToMany(mappedBy = "subCategory")
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)

//    @JoinColumn(name = "products")
//    private List<Product> products;
//    -----------------------------
    @ManyToOne()
    public Category category;
//    @ManyToOne
//    private Category category;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SubCategory{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", category=").append(category);
        sb.append('}');
        return sb.toString();
    }
}
