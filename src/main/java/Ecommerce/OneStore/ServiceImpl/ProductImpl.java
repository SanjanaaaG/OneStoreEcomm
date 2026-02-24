package Ecommerce.OneStore.ServiceImpl;

import Ecommerce.OneStore.Model.Product;
import Ecommerce.OneStore.Repository.ProductRepo;
import Ecommerce.OneStore.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements ProductService {

    @Autowired
    private ProductRepo prepo;

    @Override
    public List<Product> findAllProducts() {
        return prepo.findAll();
    }

    @Override
    public Product findById(Long productId) {
        return prepo.findById(productId).get();
    }

    @Override
    public Product SaveProduct(Product product) {
            return prepo.save(product);
    }

    @Override
    public Product updateProduct(Product product,Long productId) {
        if(prepo.existsById(productId)){
            product.setProductId(productId);
            return prepo.save(product);
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
