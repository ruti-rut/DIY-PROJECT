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
@RequestMapping("/api/project")
@CrossOrigin
public class ProjectController {
    ProjectRepository projectRepository;
    ProjectMapper projectMapper;


    @Autowired
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
    public ResponseEntity<Project> uploadProjectWithImage(@RequestPart("image") MultipartFile file
            , @RequestPart("project") ProjectCreateDTO p) {
        try {
            ImageUtils.uploadImage(file);
            Project project = projectMapper.projectCreateDTOToEntity(p);

            project.setPicturePath(file.getOriginalFilename());

            Project savedProject = projectRepository.save(project);

            return new ResponseEntity<>(savedProject, HttpStatus.CREATED);

        } catch (IOException e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}











