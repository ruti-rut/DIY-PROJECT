package com.example.diy.Mapper;

import com.example.diy.DTO.ProjectCreateDTO;
import com.example.diy.model.Project;
import com.example.diy.Mapper.CategoryMapper;

public interface ProjectCreatedDTO {
    default ProjectCreatedDTO ProjectCreatedToDTO(Project project){
        ProjectCreateDTO projectCreatedDTO=new ProjectCreateDTO();
        projectCreatedDTO.setCategory(categorytoDTO(project.getCategory()));
        projectCreatedDTO.setChallenge(project.getChallenge());
        projectCreatedDTO.setSteps(project.getSteps());
        projectCreatedDTO.setTags(project.getTags());
        projectCreatedDTO.setMaterials(project.getMaterials());
        projectCreatedDTO.setTitle(project.getTitle());
        projectCreatedDTO.setAges(project.getAges());
        projectCreatedDTO.setTimePrep(project.getTimePrep());
        projectCreatedDTO.setPicture(project.getPicture());
        projectCreatedDTO.setDescription(project.getDescription());
        projectCreatedDTO.setDraft(project.isDraft());
    }
}
