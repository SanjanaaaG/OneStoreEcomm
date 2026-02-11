package Ecommerce.OneStore.Controller;

import Ecommerce.OneStore.Model.User;
import Ecommerce.OneStore.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("api/user")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User u = userService.registerUser(user);
        if(u!=null){
            return new ResponseEntity<User>(u, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("api/user")
    public ResponseEntity<List<User>> getAllUser(){
        try {
            List<User> u = userService.getAllUsers();
            if (u != null) {
                return new ResponseEntity<>(u, HttpStatus.OK);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("api/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId){
        User u = userService.getUserById(userId);
        if(u!=null){
            return new ResponseEntity<>(u,HttpStatus.OK);
        }
        return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("api/user/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId , @RequestBody User user){
        try {
            User u = userService.updateUser(userId,user);
            if (u != null) {
                return new ResponseEntity<>(u, HttpStatus.OK);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("api/user/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long userId){
        try{
            System.out.println(userId);
            Boolean u = userService.deleteUser(userId);

            System.out.println(u);
            if(u!= false){
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
