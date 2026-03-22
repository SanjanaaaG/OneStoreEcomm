package Ecommerce.OneStore.ServiceImpl;

import Ecommerce.OneStore.Model.Category;
import Ecommerce.OneStore.Repository.CategoryRepo;
import Ecommerce.OneStore.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpl implements CategoryService {

    @Autowired
    CategoryRepo categoryRepo;


    @Override
    public List<Category> findAllCategories() {
        return categoryRepo.findAll();
    }
}
