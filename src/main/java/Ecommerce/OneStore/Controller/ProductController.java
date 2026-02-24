package Ecommerce.OneStore.Controller;

import Ecommerce.OneStore.Model.Product;
import Ecommerce.OneStore.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class ProductController {

    @Autowired
    private ProductService productservice;

    @PostMapping("/api/products")
    public ResponseEntity<Product> AddProduct(@RequestBody Product products) {
        try{
            Product p = productservice.SaveProduct(products);
            if(p!=null){
                return new ResponseEntity<>(p,HttpStatus.OK);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        try {
            List<Product> p = productservice.findAllProducts();
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

    @PutMapping("/api/products/{productId}")
    public ResponseEntity<Product> uppdateProduct(@RequestBody Product product, @PathVariable Long productId){
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
