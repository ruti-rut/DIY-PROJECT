package com.example.diy.controller;

import com.example.diy.DTO.ProjectCreateDTO;
import com.example.diy.DTO.ProjectDTO;
import com.example.diy.Mapper.ProjectMapper;
import com.example.diy.model.Project;
import com.example.diy.service.ImageUtils;
import com.example.diy.service.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/recipes")
@CrossOrigin
public class ProjectController {
    private static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "\\images\\";
    ProjectRepository projectRepository;
    ProjectMapper projectMapper;

    @Autowired //באופן אוטומטי יצור מחלקה שמממשת את הממשק בצורה מתאימה ויכניס מופע שלה
    public ProjectController(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @GetMapping("/getProject/{id}")
    public ResponseEntity<ProjectDTO> get(@PathVariable long id) throws IOException {
        Project p = projectRepository.findById(id).get();
        if (p != null)
            return new ResponseEntity<>(projectMapper.projectToDTO(p), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/uploadProject")
    public ResponseEntity<Project> uploadRecipeWithImage(@RequestPart("image") MultipartFile file
            , @RequestPart("project") ProjectCreateDTO p) {
        try {
            ImageUtils.uploadImage(file);
            Project project = projectMapper.toEntity(projectDTO);
            project.setPicturePath(file.getOriginalFilename());

            // שמירה
            Project saved = projectRepository.save(project);
            p.setPicturePath(file.getOriginalFilename());//נשמור למתכון את הנתיב של התמונה שלו
            Project project = projectRepository.save(p);
            return new ResponseEntity<>(project, HttpStatus.CREATED);

        } catch (IOException e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
