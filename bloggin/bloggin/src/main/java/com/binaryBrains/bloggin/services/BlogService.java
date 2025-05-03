package com.binaryBrains.bloggin.services;

import com.binaryBrains.bloggin.models.BlogModel;
import com.binaryBrains.bloggin.models.Blog_TagModel;
import com.binaryBrains.bloggin.models.CategoryModel;
import com.binaryBrains.bloggin.repositories.IBlogRepository;
import com.binaryBrains.bloggin.repositories.IBlog_TagRepository;
import com.binaryBrains.bloggin.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Autowired
    ICategoryRepository categoryRepository;

    @Autowired
    IBlog_TagRepository blogTagRepository;

    //GET ALL BLOGS
    public ArrayList<BlogModel> getBlogs(){
        return (ArrayList<BlogModel>) blogRepository.findAll();
    }

    //INSERT A BLOG
    public BlogModel saveBlog(BlogModel blog){
        int categoryId = blog.getCategory().getIdCategory();

        CategoryModel category = categoryRepository.findById(Long.valueOf(categoryId))
                .orElseThrow(() -> new RuntimeException("Category didn't find."));

        blog.setCategory(category);
        return blogRepository.save(blog);
    }

    //GET A BLOG BY ID
    public Optional<BlogModel> getById(Long id){
        return blogRepository.findById(id);
    }

    //UPDATE BLOG
    public BlogModel updateBlog(BlogModel request, Long id){
        BlogModel blog = blogRepository.findById(id).get();

        int categoryId = request.getCategory().getIdCategory();

        CategoryModel category = categoryRepository.findById(Long.valueOf(categoryId))
                .orElseThrow(() -> new RuntimeException("Category didn't find."));

        blog.setTitle(request.getTitle());
        blog.setContent(request.getContent());
        blog.setLastUpdate(request.getLastUpdate());
        blog.setCreatedAt(request.getCreatedAt());
        blog.setCategory(category);
        return blogRepository.save(blog);
    }


    //DELETE BLOG
    public Boolean deleteBlog(Long id){
        try{
            Optional<BlogModel> optionalBlog = blogRepository.findById(id);
            if(optionalBlog.isPresent()){
                BlogModel blog = optionalBlog.get();
                for (Blog_TagModel blog_tag : blog.getBlogTags()){
                    blog_tag.setBlog(null);
                }
                blogRepository.delete(blog);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //GET ALL BLOGS
    public ArrayList<BlogModel> getBlogsByCategory(Long id){
        CategoryModel category = categoryRepository.findById(id).get();

        ArrayList<BlogModel> categoryBlogs = new ArrayList<BlogModel>();
        ArrayList<BlogModel> allBlogs = (ArrayList<BlogModel>) blogRepository.findAll();
        for ( BlogModel blog : allBlogs){
            if(blog.getCategory() == category ){
                categoryBlogs.add(blog);
            }
        }
        return categoryBlogs;
    }

}

