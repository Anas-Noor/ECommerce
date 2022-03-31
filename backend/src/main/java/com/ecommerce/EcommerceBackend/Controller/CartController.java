package com.ecommerce.EcommerceBackend.Controller;

//import com.ecommerce.EcommerceBackend.Dto.ProductAddToCartDto;
import com.ecommerce.EcommerceBackend.Dto.CartDto;
import com.ecommerce.EcommerceBackend.Model.Cart;
import com.ecommerce.EcommerceBackend.Model.Product;
import com.ecommerce.EcommerceBackend.Service.CartService;
import com.ecommerce.EcommerceBackend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;


    @PostMapping("/")
    public void addCart(@RequestBody CartDto cartDto) {
        cartService.addCart(cartDto);
    }
//    public void addToCart(@RequestBody ProductAddToCartDto productAddToCart){
//        cartService.addToCart(productAddToCart);
//    }
    @GetMapping("")
    public List<Cart> getAllCart() {
        return cartService.getAllCart();
    }
    @GetMapping("/{id}")
    public Cart findCartById(@PathVariable Long id) {
        return cartService.findCartById(id);
    }
}
