package com.binaryBrains.bloggin.services;

import com.binaryBrains.bloggin.models.BlogModel;
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

    //GET ALL THE CATEGORIES
    public ArrayList<CategoryModel> getCategories(){
        return (ArrayList<CategoryModel>)  categoryRepository.findAll();
    }

    //INSERT A CATEGORY
    public CategoryModel saveCategory(CategoryModel category){
        return categoryRepository.save(category);
    }

    //GET THE CATEGORY BY ID
    public Optional<CategoryModel> getById(Long id){
        return categoryRepository.findById(id);
    }

    //UPDATE A CATEGORY
    public CategoryModel updateById(CategoryModel request, Long id){
        CategoryModel category = categoryRepository.findById(id).get();

        category.setName(request.getName());

        return category;
    }

    //DELETE CATEGORY
    public Boolean deleteUser(Long id){
        try {
            Optional<CategoryModel> optionalCategory = categoryRepository.findById(id);
            if(optionalCategory.isPresent()){
                CategoryModel category = optionalCategory.get();
                for (BlogModel blog : category.getBlogs()){
                    blog.setCategory(null);
                }
                categoryRepository.delete(category);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
