package Ecommerce.OneStore.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    private int categoryId;
    private String categoryName;

    @OneToMany
    @JoinColumn(name = "productId")
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();
}
