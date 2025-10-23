package com.example.diy.DTO;

import com.example.diy.model.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

public class ProjectDTO {
    private Long id;
    private UsersSimpleDTO users;
    private CategoryDTO category;

    private List<Step> steps;


    private List<Comment> comments;

    private List<Tag> tags;


    private int likesCount;         // optional

    private LocalDate createdAt;
    private String materials;
    private String title;
    private String ages;
    private String timePrep;
    private String picturePath;
    private String image;
    private String description;

}
