package Ecommerce.OneStore.Service;

import Ecommerce.OneStore.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    List<User> getAllUsers();
    User getUserById(Long userId);
    User updateUser(Long userId,User user);
    Boolean deleteUser(Long userId);
}
