package com.ecommerce.EcommerceBackend.Service;

import com.ecommerce.EcommerceBackend.Dto.ProductDto;
import com.ecommerce.EcommerceBackend.Model.CustomConstants;
import com.ecommerce.EcommerceBackend.Model.Product;
import com.ecommerce.EcommerceBackend.Model.SubCategory;
import com.ecommerce.EcommerceBackend.Model.Varient;
import com.ecommerce.EcommerceBackend.Repository.ProductRepository;
//import com.ecommerce.EcommerceBackend.Repository.SubCategoryRepository;
import com.ecommerce.EcommerceBackend.Shared.ApiResponse;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    VarientService varientService;
    //    @Autowired
//    SubCategory subCategory;
    @Value("${category.image.url}")
    String categoryImageUrl;

    @Autowired
    SubCategoryService subCategoryService;

    //
    public List<Product> getAllProducts(Long subCategoryId) {
//        Optional<Varient> varient = varientService.findVarientById(id);
        List<Product> products = productRepository.findAll();
        List<Product> products1 = new ArrayList<>();
        for (Product pr : products) {
            if (pr.getSubCategory().getId().equals(subCategoryId)) {
                products1.add(pr);
            }
        }
        return products1;

    }

    public Product findProductById(Long id) {
//        List<Product> products = this.getAllProducts(varientId);
//        Optional<Varient> varient = varientService.findVarientById(varientId);
//        Product product = new Product();
//        product.setVarient(varient.orElseThrow());
//        product = productRepository.findAll().stream().filter(c -> Long.valueOf(c.getId()) == id).findAny().get();
        Product product = productRepository.findById(id).orElseThrow(null);
        return product;
    }
//    public Product findProductById(Long id,Long varientId) {
//        Varient varient = new Varient();
//        productRepository.delete(productRepository.findAll().stream().filter(c -> Long.valueOf(c.getId()) == id
//                ).findAny().get());
//    }

    public void addProduct(List<Long> ids, Long id, MultipartFile f, ProductDto productDto) throws IOException {
        //new code:
        Product product = new Product();
        String unique = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
        if(saveCategoryImage(productDto.getMultipart(),productDto.getName(),unique)){

            Product category = new Product();
            product.setImage(categoryImageUrl+productDto.getName()+"/"+unique+productDto.getMultipart().getOriginalFilename());
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            product.setStock(productDto.getStock());
            product.setSubCategory(productDto.getSubCategory());
            product.setVarients(productDto.getVarients());
            productRepository.save(product);
//            category.setActive(true);
//            categoryRepository.save(category);
//            return new ApiResponse(Status.Status_Ok,CustomConstants.CAT_POSTED,category);
        }
//            List<Varient> varients = new ArrayList<>();
//            for(Long i : ids) {
//                varients.add(varientService.findVarientById(i));
//            }
//        productRepository.save(product);
    }




//        product.setName(productDto.getName());
//        product.setDescription(productDto.getDescription());
//        product.setPrice(productDto.getPrice());
//        product.setStock(productDto.getStock());
//        SubCategory subCategory = new SubCategory();
//        subCategory.setId(id);
//        product.setSubCategory(subCategory);
//        List<Varient> varients = new ArrayList<>();
//        for(Long i : ids) {
//            varients.add(varientService.findVarientById(i));
//        }
//        product.setVarients(varients);
//        Varient varient = new Varient();
//        varient.setId(id);
//        product1.setVarient(varient);
//
//        product1.setSubCategory(product.getSubCategoryId());
//        product1.setSubCategory(
//                subCategoryRepository.findAll().stream().filter(x->Long.valueOf(x.getId())==subCategoryId).findAny().get()
//        );
//        productRepository.save(product);


    public void updateProduct(Long id,ProductDto product){
        Product product1= productRepository.findById(id).orElseThrow(null);
        product1.setName(product.getName());
        product1.setVarients(product.getVarients());
        product1.setSubCategory(product.getSubCategory());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setImage(product.getImage());
        product1.setStock(product.getStock());
        productRepository.save(product1);
//        product1.setId(id);
//        product1.setName(product.getName());
//        product1.setDescription(product.getDescription());
//        Varient varient = new Varient();
//        varient.setId(varientId);
////        product1.setVarient(varient);
//        product1.setPrice(product.getPrice());
//        product1.setStock(product.getStock());
//        productRepository.saveAndFlush(product1);

    }
    public void deleteProductById(Long id){
//        productRepository.delete(productRepository.findAll().stream().filter(c -> Long.valueOf(c.getId()) == id).findAny().get());
        productRepository.delete(this.findProductById(id));
    }

//    public void deleteAllProducts(){
//        productRepository.deleteAll();
//    }

    //new method code:
    public Boolean saveCategoryImage(MultipartFile file, String name, String unique){
        try {

            String UPLOADED_FOLDER_NEW = CustomConstants.SERVER_PATH+"//"+name+"//";

            File dir = new File(UPLOADED_FOLDER_NEW);
            dir.setExecutable(true);
            dir.setReadable(true);
            dir.setWritable(true);

            if(!dir.exists()){
                dir.mkdirs();
            }

            BufferedImage inputImage = ImageIO.read(file.getInputStream());

            BufferedImage resized = resize(inputImage, 30, 30);

            String format = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            ImageIO.write(resized, format, new File(UPLOADED_FOLDER_NEW + unique+ file.getOriginalFilename()));

        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //new code:

    private BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

}



