package com.binaryBrains.bloggin.models;

import jakarta.persistence.*;

@Entity
@Table(name = "bg04_blog_tag")
public class Blog_TagModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_blog_tag")
    private Integer idBlogTag;

    @ManyToOne
    @JoinColumn(name = "fk_id_blog", nullable = false)
    private BlogModel blog;

    @ManyToOne
    @JoinColumn(name = "fk_id_tag", nullable = false)
    private TagModel tag;

    // Getters and Setters
    public Integer getIdBlogTag() {
        return idBlogTag;
    }

    public void setIdBlogTag(Integer idBlogTag) {
        this.idBlogTag = idBlogTag;
    }

    public BlogModel getBlog() {
        return blog;
    }

    public void setBlog(BlogModel blog) {
        this.blog = blog;
    }

    public TagModel getTag() {
        return tag;
    }

    public void setTag(TagModel tag) {
        this.tag = tag;
    }
}