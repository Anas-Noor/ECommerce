package com.ecommerce.EcommerceBackend.Repository;

import com.ecommerce.EcommerceBackend.Model.Cart;
import com.ecommerce.EcommerceBackend.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
//
//    @Query(value = "select * from cart",nativeQuery = true)
//    public Cart getCart();
}
