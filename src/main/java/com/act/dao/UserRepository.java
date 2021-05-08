package com.act.dao;

import com.act.entity.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.act.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>{

    @Query("SELECT new com.act.entity.dto.UserDTO(" +
            "u.id, u.firstName, u.lastName, u.username)" +
            " FROM User u")
    Optional<List<UserDTO>> fetchUsersDTO(); // FETCH A LIST OF USER-DTO
}
