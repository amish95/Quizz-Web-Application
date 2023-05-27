package com.QuizzApplication.QuizzWebApplication.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuizzApplication.QuizzWebApplication.Models.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
