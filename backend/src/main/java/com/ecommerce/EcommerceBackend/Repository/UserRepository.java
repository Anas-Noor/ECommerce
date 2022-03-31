package com.ecommerce.EcommerceBackend.Repository;

import com.ecommerce.EcommerceBackend.Model.User;
import com.ecommerce.EcommerceBackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    @Query(value = "select * from users",nativeQuery = true)
    public List<User> getAllUsers();
    @Query(value = "select * from users WHERE id=:id",nativeQuery = true)
    public User getUserById(Long id);

}
