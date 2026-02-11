package Ecommerce.OneStore.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue
    private Long addressId;
    private String houseNo;
    private String street;
    private String city;
    private String state;
    private Long pincode;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
