package com.binaryBrains.bloggin.controllers;

import com.binaryBrains.bloggin.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog_tag")
public class Blog_TagController {
    @Autowired
    private BlogService blogService;
}
