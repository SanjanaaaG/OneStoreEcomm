package Ecommerce.OneStore.Dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductRequest {
    private String productName;
    private String productDescription;
    private Double amount;
    private Long categoryId;
    private MultipartFile image;
}
