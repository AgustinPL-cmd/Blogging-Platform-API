package com.binaryBrains.bloggin.repositories;

import com.binaryBrains.bloggin.models.TagModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ITagRepository extends JpaRepository<TagModel, Long> {
}
