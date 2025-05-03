package com.binaryBrains.bloggin.repositories;

import com.binaryBrains.bloggin.models.Blog_TagModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlog_TagRepository extends JpaRepository<Blog_TagModel, Long> {
}
