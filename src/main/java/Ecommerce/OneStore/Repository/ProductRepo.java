package Ecommerce.OneStore.Repository;

import Ecommerce.OneStore.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

     List<Product> findByCategory_CategoryName(String categoryName);
     List<Product> findByCategory_CategoryNameAndProductName(String CategoryName , String ProductName);

     List<Product> findByProductName(String productName);

//     List<Product> findByCategory_CategoryNameAndProductName(String productName);

}
