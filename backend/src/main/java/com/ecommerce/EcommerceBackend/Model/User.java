package com.ecommerce.EcommerceBackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;
import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private com.ecommerce.EcommerceBackend.Enums.Role role;

    @Column(name = "password")
    private String password;

//        @JsonIgnore
//        @OneToMany(mappedBy = "user",
//                fetch = FetchType.LAZY)
//        private List<Order> orders;

    public com.ecommerce.EcommerceBackend.Enums.Role getRole(){
        return role;
    }

    public void setRole(com.ecommerce.EcommerceBackend.Enums.Role role) {
        this.role=role;
    }
}
