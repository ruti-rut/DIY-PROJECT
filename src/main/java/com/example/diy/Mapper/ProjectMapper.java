package com.example.diy.Mapper;

import com.example.diy.DTO.ProjectCreateDTO;
import com.example.diy.model.Project;

public interface ProjectMapper {
    default ProjectCreateDTO projectToDTO(Project project){
         ProjectCreateDTO proj=new ProjectCreateDTO();
        return proj;
    }
}
