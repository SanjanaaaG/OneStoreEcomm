package Ecommerce.OneStore.ServiceImpl;

import Ecommerce.OneStore.Dto.ProductRequest;
import Ecommerce.OneStore.Dto.ProductResponse;
import Ecommerce.OneStore.Model.Category;
import Ecommerce.OneStore.Model.Product;
import Ecommerce.OneStore.Repository.CategoryRepo;
import Ecommerce.OneStore.Repository.ProductRepo;
import Ecommerce.OneStore.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductImpl implements ProductService {

    @Autowired
    private ProductRepo prepo;

    @Autowired
    private CategoryRepo crepo;

    @Override
    public List<ProductResponse> findAllProducts() {
        try {
            List<Product> products = prepo.findAll();

            // Convert each Product to ProductResponse (Base64 image included)
            return products.stream()
                    .map(ProductResponse::new) // uses your constructor that encodes image
                    .collect(Collectors.toList());

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Product findById(Long productId) {
        return prepo.findById(productId).get();
    }

    @Override
    public Product SaveProduct(ProductRequest product, MultipartFile imageFile)throws IOException {
        Category category = crepo.findById(product.getCategoryId()).orElse(null);
        Product product1 = new Product();
        product1.setProductName(product.getProductName());
        product1.setProductDescription(product.getProductDescription());
        product1.setAmount(product.getAmount());
        product1.setCategory(category);
        product1.setImage(imageFile.getBytes());
        return prepo.save(product1);
    }

//    @Override
//    public Product updateProduct(ProductRequest product,Long productId) throws IOException {
//        if(prepo.existsById(productId)){
////            product.setProductId(productId);
////            return prepo.save(product);
////            MultipartFile file = product.getImage();
//            Category category = crepo.findById(product.getCategoryId()).orElse(null);
//            Product product1 = new Product();
//            product1.setProductName(product.getProductName());
//            product1.setProductDescription(product.getProductDescription());
//            product1.setAmount(product.getAmount());
//            product1.setCategory(category);
//            product1.setImage(product1.getImage());
//            return prepo.save(product1);
//        }
//        return null;
//    }

    @Override
    public Product updateProduct(ProductRequest product, Long productId) throws IOException {
        Category category = crepo.findById(product.getCategoryId()).orElse(null);
        Product existingProduct = prepo.findById(productId).orElse(null);
        if(existingProduct != null){
            existingProduct.setProductName(product.getProductName());
            existingProduct.setProductDescription(product.getProductDescription());
            existingProduct.setAmount(product.getAmount());
            existingProduct.setCategory(category);
            MultipartFile file = product.getImage();
            if(file != null && !file.isEmpty()){
                existingProduct.setImage(file.getBytes());
            }
            return prepo.save(existingProduct);
        }
        return null;
    }

    @Override
    public Boolean deleteProduct(Long productId) {
        if(prepo.existsById(productId)){
            prepo.deleteById(productId);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> findByProductName(String productName) {
        if(productName!=null){
            return prepo.findByProductName(productName);
        }
        return null;
    }

    @Override
    public List<Product> findByCategory_CategoryName(String categoryName) {
        if(categoryName!=null){
            return prepo.findByCategory_CategoryName(categoryName);
        }
        return null;
    }

    @Override
    public List<Product> findByCategory_CategoryNameAndProductName(String categoryName, String productName) {
        if(categoryName!=null && productName!=null){
            return prepo.findByCategory_CategoryNameAndProductName(categoryName,productName);
        }
        return null;
    }


}
