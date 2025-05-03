package com.binaryBrains.bloggin.controllers;

import com.binaryBrains.bloggin.models.BlogModel;
import com.binaryBrains.bloggin.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    //GET ALL BLOGS
    @GetMapping
    public ArrayList<BlogModel> getBlogs(){
        return this.blogService.getBlogs();
    }

    //INSERT A BLOG
    @PostMapping
    public BlogModel saveBlog(@RequestBody BlogModel blog){
        return this.blogService.saveBlog(blog);
    }

    //GET A BLOG BY ID
    @GetMapping(path = "/{id}")
    public Optional<BlogModel> getBlogById(@PathVariable Long id){
        return this.blogService.getById(id);
    }

    //UPDATE BLOG
    @PutMapping(path = "{id}")
    public BlogModel updateBlogById(@RequestBody BlogModel request, @PathVariable("id") Long id){
        return blogService.updateBlog(request,id);
    }

    //DELETE BLOG
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.blogService.deleteBlog(id);
        if(ok){
            return "Blog deleted";
        }
        return "We had a problem";
    }

    //GET BLOGS BY CATEGORY
    @GetMapping (path = "/category/{id}")
    public ArrayList<BlogModel> getBlogsByCategory(@PathVariable("id") Long id){
        return this.blogService.getBlogsByCategory(id);
    }
}
