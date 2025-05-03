package com.binaryBrains.bloggin.repositories;

import com.binaryBrains.bloggin.models.BlogModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<BlogModel, Long> {
}
