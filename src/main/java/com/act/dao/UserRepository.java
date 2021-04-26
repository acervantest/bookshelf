package com.act.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.act.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
