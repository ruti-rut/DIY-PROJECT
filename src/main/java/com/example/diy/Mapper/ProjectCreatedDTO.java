package com.example.diy.Mapper;

import com.example.diy.DTO.ProjectCreateDTO;
import com.example.diy.model.Project;
import com.example.diy.Mapper.CategoryMapper;
public interface ProjectCreatedDTO {
    default ProjectCreateDTO ProjectCreateToDTO(Project project, CategoryMapper cm){
        ProjectCreateDTO projectCreateDTO=new ProjectCreateDTO();
        projectCreateDTO.setCategory(cm.categoryToDTO(project.getCategory()));
        projectCreateDTO.setChallenge(project.getChallenge());
        projectCreateDTO.setSteps(project.getSteps());
        projectCreateDTO.setTags(project.getTags());
        projectCreateDTO.setMaterials(project.getMaterials());
        projectCreateDTO.setTitle(project.getTitle());
        projectCreateDTO.setAges(project.getAges());
        projectCreateDTO.setTimePrep(project.getTimePrep());
        projectCreateDTO.setPicture(project.getPicture());
        projectCreateDTO.setDescription(project.getDescription());
        projectCreateDTO.setDraft(project.isDraft());
        return projectCreateDTO;
    }
}
