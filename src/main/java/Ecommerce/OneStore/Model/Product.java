package Ecommerce.OneStore.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue
    private Long productId;
    private String productName;
    private String productDescription;
    private Double amount;
    @Lob
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonBackReference
    private Category category;


}
