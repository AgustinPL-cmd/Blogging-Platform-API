package com.binaryBrains.bloggin.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bg01_blog")
public class BlogModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_blog")
    private Integer idBlog;

    @Column(name = "tx_title", nullable = false)
    private String title;

    @Column(name = "tx_content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "fk_id_category")
    private CategoryModel category;

    @Column(name = "fh_created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "fh_last_update", nullable = false)
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.REMOVE)
    private List<Blog_TagModel> blogTags;

    // Getters and Setters
    public Integer getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Integer idBlog) {
        this.idBlog = idBlog;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Blog_TagModel> getBlogTags() {
        return blogTags;
    }

    public void setBlogTags(List<Blog_TagModel> blogTags) {
        this.blogTags = blogTags;
    }
}