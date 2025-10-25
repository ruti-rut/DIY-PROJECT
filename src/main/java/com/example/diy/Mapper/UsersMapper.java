package com.example.diy.Mapper;

import com.example.diy.DTO.UsersSimpleDTO;
import com.example.diy.model.Users;
import org.mapstruct.Mapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    default UsersSimpleDTO toSimpleDTO(Users user) throws IOException {
        if (user == null) return null;

        UsersSimpleDTO usersSimpleDTO = new UsersSimpleDTO();
        usersSimpleDTO.setId(user.getId());
        usersSimpleDTO.setUserName(user.getUserName());
        usersSimpleDTO.setProfilePicturePath(user.getProfilePicturePath());

        Path filename = Paths.get(user.getProfilePicturePath());//לוקח את הנתיב של התמונה
        byte[] byteImage = Files.readAllBytes(filename);//מעביר אותה למערך של ביטים
        //כדי להפחית את תעבורת הרשת, נקודד למחרוזת של base64 שהיא קטנה יותר
        usersSimpleDTO.setProfilePicture(Base64.getEncoder().encodeToString(byteImage));

        return usersSimpleDTO;
    }

    default Users toEntityFromSimpleDTO(UsersSimpleDTO dto) {
        Users users = new Users();
        users.setId(dto.getId());
        users.setUserName(dto.getUserName());
        users.setProfilePicturePath(dto.getProfilePicturePath());
        return users;
    }


}
