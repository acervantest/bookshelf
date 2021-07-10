package com.act.mappers;

import com.act.entity.User;
import com.act.entity.dto.BookDTO;
import com.act.entity.dto.UserDetailDTO;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserMapper {

    public UserDetailDTO convertToDto(User user, List<BookDTO> books) {

        books = ( books != null && books.size() > 0 ) ? books : null;

        UserDetailDTO userDetailDTO = new UserDetailDTO(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                books );

        return userDetailDTO;
    }
}
