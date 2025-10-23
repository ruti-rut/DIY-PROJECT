package com.example.diy.DTO;

public class ProjectListDTO {
    private Long id;
    private UsersSimpleDTO usersSimpleDTO;
    private String title;
    private String picture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsersSimpleDTO getUsersSimpleDTO() {
        return usersSimpleDTO;
    }

    public void setUsersSimpleDTO(UsersSimpleDTO usersSimpleDTO) {
        this.usersSimpleDTO = usersSimpleDTO;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
