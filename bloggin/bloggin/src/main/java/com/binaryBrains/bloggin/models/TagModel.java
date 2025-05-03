package com.binaryBrains.bloggin.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "bg03_tag")
public class TagModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tag")
    private Integer idTag;

    @Column(name = "tx_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.REMOVE)
    private List<Blog_TagModel> blogTags;

    // Getters and Setters
    public Integer getIdTag() {
        return idTag;
    }

    public void setIdTag(Integer idTag) {
        this.idTag = idTag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog_TagModel> getBlogTags() {
        return blogTags;
    }

    public void setBlogTags(List<Blog_TagModel> blogTags) {
        this.blogTags = blogTags;
    }
}
