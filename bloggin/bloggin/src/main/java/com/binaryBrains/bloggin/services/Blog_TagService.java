package com.binaryBrains.bloggin.services;

import com.binaryBrains.bloggin.models.BlogModel;
import com.binaryBrains.bloggin.models.Blog_TagModel;
import com.binaryBrains.bloggin.models.TagModel;
import com.binaryBrains.bloggin.repositories.IBlogRepository;
import com.binaryBrains.bloggin.repositories.IBlog_TagRepository;
import com.binaryBrains.bloggin.repositories.ITagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Blog_TagService {
    @Autowired
    IBlog_TagRepository blogTagRepository;

    @Autowired
    ITagRepository tagRepository;

    @Autowired
    IBlogRepository blogRepository;

    //INSERT A BLOG
    public Blog_TagModel saveBlogTag(Blog_TagModel blogTag){
        int tagId = blogTag.getTag().getIdTag();
        int blogId = blogTag.getBlog().getIdBlog();

        TagModel tag = tagRepository.findById(Long.valueOf(tagId))
                .orElseThrow(() -> new RuntimeException("Tag didn't find"));

        blogTag.setTag(tag);

        BlogModel blog = blogRepository.findById(Long.valueOf(blogId))
                .orElseThrow(() -> new RuntimeException("Blog didn't find"));

        return blogTagRepository.save(blogTag);
    }
}
