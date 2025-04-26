package com.binaryBrains.bloggin.controllers;

import com.binaryBrains.bloggin.models.CategoryModel;
import com.binaryBrains.bloggin.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ArrayList<CategoryModel> getCategories(){
        return this.categoryService.getCategories();
    }

    @PostMapping
    public CategoryModel saveCategory(@RequestBody CategoryModel category){
        return this.categoryService.saveCategory(category);
    }

    @GetMapping(path = "/{id}")
    public Optional<CategoryModel> getCategoryById(@PathVariable Long id){
        return this.categoryService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public CategoryModel updateUserById(@RequestBody CategoryModel request, @PathVariable("id") Long id){
        return this.categoryService.updateById(request, id);
    }

    @DeleteMapping(path="/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.categoryService.deleteUser(id);

        if(ok){
            return "Category with id: "+id+" deleted";
        }
        else{
            return "Error, we have a problem. ";
        }

    }
}
