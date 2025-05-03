package com.binaryBrains.bloggin.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "b02_category")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Integer idCategory;

    @Column(name = "tx_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<BlogModel> blogs;

    // Getters and Setters
    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BlogModel> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<BlogModel> blogs) {
        this.blogs = blogs;
    }
}