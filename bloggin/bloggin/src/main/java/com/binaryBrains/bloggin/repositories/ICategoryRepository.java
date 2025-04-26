package com.binaryBrains.bloggin.repositories;

import com.binaryBrains.bloggin.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Clase que permite hacer querys a la base de datos
@Repository
public interface ICategoryRepository extends JpaRepository<CategoryModel, Long> {
    

}
