package com.binaryBrains.bloggin.controllers;

import com.binaryBrains.bloggin.repositories.ITagRepository;
import com.binaryBrains.bloggin.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;
}
