package com.ecommerce.EcommerceBackend.Service;

import com.ecommerce.EcommerceBackend.Dto.CartDto;
//import com.ecommerce.EcommerceBackend.Dto.ProductAddToCartDto;
import com.ecommerce.EcommerceBackend.Model.Cart;
import com.ecommerce.EcommerceBackend.Model.Product;
import com.ecommerce.EcommerceBackend.Repository.CartRepository;
import com.ecommerce.EcommerceBackend.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.pattern.PathPatternRouteMatcher;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductService productService;

    public List<Cart> getAllCart() {
        return cartRepository.findAll();
    }
    public Cart findCartById(Long id) {
       return cartRepository.findById(id).orElseThrow(null);
    }
    public void addCart(CartDto cartDto) {
        Cart cart = new Cart();
        double price=0;
//
//        List<Product> products = new ArrayList<>();
//        Double price = 0.00;
//        for(Long id : ids) {
//            products.add(productService.findProductById(id));
//        }
//        for(Product pr : products) {
//            price = price + pr.getPrice();
//        }
        cart.setProducts(cartDto.getProducts());
        for(Product pr : cart.getProducts()) {
            price = price + pr.getPrice();
        }
//        cart.getProducts().add()

//        cart.setAmount(price);
//        List<Product> productList = productService.getAllProducts(varientId);
//        List<Product> products = new ArrayList<>();
//        for(Product product : productList) {
//            if(product.getId().equals(ids)) {
//                products.add(product);
//            }
//        }
//        cart.setProducts(products);
        cart.setAmount(price);
        cartRepository.save(cart);
    }

//    public void addCart(CartDto cartDto, List<Long> ids) {
//    }

//    public void createCart(){
//        Cart cart = new Cart();
//    }
//    public double calculateTotalBill(List<ProductAddToCartDto> products){
//        double totalBill = 0;
//        for (ProductAddToCartDto item : products) {
//            totalBill+=item.getPrice();
//        }
//        return totalBill;
//    }
//    public void addToCart(ProductAddToCartDto productAddToCartDto) {
//        Product product=productRepository.findAll().stream().filter(x->x.getId()==productAddToCartDto.getProductId()).findAny().get();
//        Cart cart=new Cart();
//        createCart();
//        cart=cartRepository.getCart();
//        cart.getProducts().add(productAddToCartDto);
//        calculateTotalBill(cart.getProducts());
//    }
}
