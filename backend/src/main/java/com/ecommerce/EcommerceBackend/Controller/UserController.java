//package com.ecommerce.EcommerceBackend.Controller;
//
//import com.ecommerce.EcommerceBackend.Dto.ProductDto;
//import com.ecommerce.EcommerceBackend.Dto.UserDto;
//import com.ecommerce.EcommerceBackend.Model.Product;
//import com.ecommerce.EcommerceBackend.Model.User;
//import com.ecommerce.EcommerceBackend.Service.ProductService;
//import com.ecommerce.EcommerceBackend.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/api/user")
//public class UserController {
//    @Autowired
//    ProductService productService;
//    @Autowired
//    UserService userService;
//
//
//    @GetMapping("/")
//    public List<User> getAllUsers(){
//        return userService.getAllUsers();
//    }
//    @PostMapping("/")
//    public void addUser(@RequestBody UserDto userDto){
//        userService.addUser(userDto);
//    }
//    @PutMapping("/{id}")
//    public void updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
//        userService.updateUser(id,userDto);
//    }
//    @DeleteMapping("/{id}")
//    public void deleteUserById(@PathVariable Long id){
//        userService.deleteUserById(id);
//    }
//    @DeleteMapping("/")
//    public void deleteAllUsers(){
//        userService.deleteAllUsers();
//    }
//
//}
