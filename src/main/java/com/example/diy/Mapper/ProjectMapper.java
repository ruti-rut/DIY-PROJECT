package com.example.diy.Mapper;

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
}
