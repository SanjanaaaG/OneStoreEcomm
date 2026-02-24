package Ecommerce.OneStore.Service;

import Ecommerce.OneStore.Model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAllProducts();
    public Product findById(Long productId);
    public Product SaveProduct(Product product);
    public Product updateProduct(Product product,Long productId);
    public Boolean deleteProduct(Long productId);
    List<Product> findByProductName(String productName);
    List<Product> findByCategory_CategoryName(String categoryName);
    List<Product> findByCategory_CategoryNameAndProductName(String categoryName,String productName);
}
