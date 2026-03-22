package Ecommerce.OneStore.Controller;

import Ecommerce.OneStore.Model.Category;
import Ecommerce.OneStore.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryservice;

    @GetMapping("/api/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        try {
            List<Category> c = categoryservice.findAllCategories();
            if (c != null) {
                return new ResponseEntity<>(c, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}