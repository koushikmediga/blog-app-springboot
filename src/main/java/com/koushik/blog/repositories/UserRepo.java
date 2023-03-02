package com.koushik.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koushik.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
