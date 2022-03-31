package com.ecommerce.EcommerceBackend.Repository;

import com.ecommerce.EcommerceBackend.Model.Category;
import com.ecommerce.EcommerceBackend.Model.Varient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VarientRepository  extends JpaRepository<Varient,Long> {

}
