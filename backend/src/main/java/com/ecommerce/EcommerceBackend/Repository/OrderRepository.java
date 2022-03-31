package com.ecommerce.EcommerceBackend.Repository;

import com.ecommerce.EcommerceBackend.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {
}
