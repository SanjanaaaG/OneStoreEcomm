package Ecommerce.OneStore.Dto;

import Ecommerce.OneStore.Model.Product;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Data
public class ProductResponse {
    private Long productId;
    private String productName;
    private String productDescription;
    private Double amount;
    private Long categoryId;
    private String categoryName;
    private String image;

    public ProductResponse(Product product) {
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.productDescription = product.getProductDescription();
        this.amount = product.getAmount();
        this.categoryId = product.getCategory() != null ? product.getCategory().getCategoryId() : null;
        this.categoryName = product.getCategory() != null ? product.getCategory().getCategoryName() : null;

        // Convert byte[] to Base64
        if (product.getImage() != null) {
            this.image = Base64.getEncoder().encodeToString(product.getImage());
        }
    }

}
