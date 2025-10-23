package com.example.diy.DTO;

import java.time.LocalDate;

public class CommentDTO {
    private Long id;
    private String content;
    private LocalDate createdDate;
    private UsersSimpleDTO user;
}
