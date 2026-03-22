package Ecommerce.OneStore.Controller;

import Ecommerce.OneStore.Dto.ProductRequest;
import Ecommerce.OneStore.Dto.ProductResponse;
import Ecommerce.OneStore.Model.Product;
import Ecommerce.OneStore.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class ProductController {

    @Autowired
    private ProductService productservice;

    @PostMapping(value = "/api/products" , consumes = {"multipart/form-data"})
    public ResponseEntity<Product> AddProduct(@ModelAttribute ProductRequest products) throws IOException {
        try{
            Product p = productservice.SaveProduct(products, products.getImage());
            if(p!=null){
                return new ResponseEntity<>(p,HttpStatus.OK);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/api/products")
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        try {
            List<ProductResponse> p = productservice.findAllProducts();
            if(p != null) {
                return new ResponseEntity<>(p, HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId){
        try{
            Product p = productservice.findById(productId);
            if(p!=null){
                return new ResponseEntity<>(p,HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value ="/api/products/{productId}" , consumes = {"multipart/form-data"})
    public ResponseEntity<Product> uppdateProduct(@ModelAttribute ProductRequest product, @PathVariable Long productId){
        try{
            Product p = productservice.updateProduct(product,productId);
            if(p!=null){
                return new ResponseEntity<>(p,HttpStatus.OK);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/api/products/{productId}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Long productId){
        try{
            Boolean p = productservice.deleteProduct(productId);
            if(p==true){
                return new ResponseEntity<>(true,HttpStatus.OK);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(false,HttpStatus.OK);
    }

    @GetMapping("/api/products/category/{productName}")
    public ResponseEntity<List<Product>> findProductByProductName(@PathVariable String productName){
        try {
            List<Product> p = productservice.findByProductName(productName);
            if(p != null) {
                return new ResponseEntity<>(p, HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("api/products/category/name/{categoryName}")
    public ResponseEntity<List<Product>> findAllProductsByCategoryName(@PathVariable String categoryName){
        try{
            List<Product> p = productservice.findByCategory_CategoryName(categoryName);
            if(p!=null){
                return new ResponseEntity<>(p,HttpStatus.OK);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("api/products/category/{categoryName}/{productName}")
    public ResponseEntity<List<Product>> findAllProductsByCategoryNameAndProductName(@PathVariable String categoryName,@PathVariable String productName){
        try{
            List<Product> p = productservice.findByCategory_CategoryNameAndProductName(categoryName,productName);
            if(p!=null){
                return new ResponseEntity<>(p,HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
