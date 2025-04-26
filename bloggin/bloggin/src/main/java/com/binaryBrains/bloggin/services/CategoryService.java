package com.binaryBrains.bloggin.services;

import com.binaryBrains.bloggin.models.CategoryModel;
import com.binaryBrains.bloggin.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CategoryService {
    //Inyección de Dependencias
    @Autowired
    ICategoryRepository categoryRepository;

    public ArrayList<CategoryModel> getCategories(){
        return (ArrayList<CategoryModel>)  categoryRepository.findAll();
    }

    public CategoryModel saveCategory(CategoryModel category){
        return categoryRepository.save(category);
    }

    public Optional<CategoryModel> getById(Long id){
        return categoryRepository.findById(id);
    }

    public CategoryModel updateById(CategoryModel request, Long id){
        CategoryModel category = categoryRepository.findById(id).get();

        category.setName(request.getName());

        return category;
    }

    public Boolean deleteUser(Long id){
        try {
            categoryRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
