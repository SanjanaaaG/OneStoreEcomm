package Ecommerce.OneStore.ServiceImpl;

import Ecommerce.OneStore.Model.User;
import Ecommerce.OneStore.Repository.UserRepo;
import Ecommerce.OneStore.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserService {

    @Autowired UserRepo urepo;

    @Override
    public User registerUser(User user) {
        return urepo.save(user);
    }

    @Override
    public Boolean deleteUser(Long userId) {
        if(urepo.existsById(userId)){
            urepo.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public User getUserById(Long userId) {
        return urepo.findById(userId).get();
    }

    @Override
    public User updateUser(Long userId,User user) {
        if(urepo.existsById(userId)){
            user.setUserId(userId);
            return urepo.save(user);
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return urepo.findAll();
    }

}
