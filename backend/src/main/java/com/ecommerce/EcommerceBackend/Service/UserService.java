package com.ecommerce.EcommerceBackend.Service;

import org.springframework.stereotype.Service;
import com.ecommerce.EcommerceBackend.Dto.UserDto;
import com.ecommerce.EcommerceBackend.Model.User;
import com.ecommerce.EcommerceBackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }
    public User getUserById(Long id){
        return userRepository.getUserById(id);
    }

    public void addUser(UserDto user){
        User user1=new User();
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setRole(user.getRole());
        userRepository.save(user1);
    }

    public void updateUser(Long id,UserDto user){
        User user1=new User();
        user1.setFirstName(user.getFirstName());
        user1.setRole(user.getRole());
        user1.setLastName(user.getLastName());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        userRepository.save(user1);
    }
    public void deleteUserById(Long id){
        userRepository.delete(userRepository.findAll().stream().filter(c -> Long.valueOf(c.getId()) == id).findAny().get());
    }
    public void deleteAllUsers(){
        userRepository.deleteAll();
    }

}

