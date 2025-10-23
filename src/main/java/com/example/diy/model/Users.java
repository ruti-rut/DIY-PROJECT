package com.example.diy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Users {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String password;
    private String userName;
    private String mail;
    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<Project> myProjects;

    private String profilePicturePath;
    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<Comment> myComments;


    @ManyToMany
    private List<Project> favoriteProjects;
    @ManyToMany(mappedBy = "likedByUsers")
    private List<Project> likeProjects;
    private String city;
    private String aboutMe;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public List<Project> getLikeProjects() {
        return likeProjects;
    }

    public void setLikeProjects(List<Project> likeProjects) {
        this.likeProjects = likeProjects;
    }

    public List<Project> getFavoriteProjects() {
        return favoriteProjects;
    }

    public void setFavoriteProjects(List<Project> favoriteProjects) {
        this.favoriteProjects = favoriteProjects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Project> getMyProjects() {
        return myProjects;
    }

    public void setMyProjects(List<Project> myProjects) {
        this.myProjects = myProjects;
    }

    public String getProfilePicture() {
        return profilePicturePath;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicturePath = profilePicture;
    }

    public List<Comment> getMyComments() {
        return myComments;
    }

    public void setMyComments(List<Comment> myComments) {
        this.myComments = myComments;
    }

}
