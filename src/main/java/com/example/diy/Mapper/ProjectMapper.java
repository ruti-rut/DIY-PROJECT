package com.example.diy.Mapper;

import com.example.diy.DTO.ProjectCreateDTO;
import com.example.diy.DTO.ProjectDTO;
import com.example.diy.DTO.ProjectListDTO;
import com.example.diy.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@Mapper(componentModel = "spring", uses = {UsersMapper.class})
public interface ProjectMapper {
        @Mapping(source = "users", target = "usersSimpleDTO")
        ProjectListDTO projectToListDTO(Project project);

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
