package com.ecommerce.EcommerceBackend.Controller;

import com.ecommerce.EcommerceBackend.Dto.ProductDto;
import com.ecommerce.EcommerceBackend.Model.Product;
import com.ecommerce.EcommerceBackend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{subCategoryId}/product")
    public List<Product> getAllProducts(@PathVariable Long subCategoryId){
        return productService.getAllProducts(subCategoryId);
    }

    @PostMapping()
    public ResponseEntity<String> addProduct(@RequestParam List<Long> ids, @RequestParam Long id, @ModelAttribute ProductDto productDto) throws IOException {
//        if(file.isEmpty() || !file.getContentType().equals("image/jpeg")) {
//            try {
//                throw new Exception("file needed or file is not in jpeg format");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        else {
            productService.addProduct(ids, id, productDto.getMultipart(),productDto);
//           return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
//        }
        return null;
    }
    @PutMapping("/product/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto){
        productService.updateProduct(id,productDto);
    }
    @DeleteMapping("/{varientId}/product/{id}")
    public void deleteProductById(@PathVariable Long varientId,@PathVariable Long id){
        productService.deleteProductById(id);
    }
    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id){
        return productService.findProductById(id);
    }

}
