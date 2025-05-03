package com.binaryBrains.bloggin.services;

import com.binaryBrains.bloggin.models.TagModel;
import com.binaryBrains.bloggin.repositories.ITagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TagService {
    @Autowired
    ITagRepository tagRepository;



}
