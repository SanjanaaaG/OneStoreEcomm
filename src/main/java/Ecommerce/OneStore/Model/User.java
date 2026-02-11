package Ecommerce.OneStore.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String password;

    @OneToMany
    List<Address> addresses = new ArrayList<>();
}
