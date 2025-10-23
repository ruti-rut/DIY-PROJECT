package com.example.diy.Mapper;

import com.example.diy.DTO.ProjectDTO;
import com.example.diy.DTO.UsersSimpleDTO;
import com.example.diy.model.Project;

public interface ProjectMapper {
    default ProjectDTO projectToDTO(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(project.getId());

    }
}
