package Ecommerce.OneStore.Service;

import Ecommerce.OneStore.Dto.ProductRequest;
import Ecommerce.OneStore.Dto.ProductResponse;
import Ecommerce.OneStore.Model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    public List<ProductResponse> findAllProducts();
    public Product findById(Long productId);
    public Product SaveProduct(ProductRequest productRequest, MultipartFile image)throws IOException;
    public Product updateProduct(ProductRequest product,Long productId) throws IOException;
    public Boolean deleteProduct(Long productId);
    List<Product> findByProductName(String productName);
    List<Product> findByCategory_CategoryName(String categoryName);
    List<Product> findByCategory_CategoryNameAndProductName(String categoryName,String productName);
}
