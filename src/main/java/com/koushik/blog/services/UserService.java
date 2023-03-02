package com.koushik.blog.services;

import java.util.List;

import com.koushik.blog.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);
	UserDto updatUser(UserDto use, Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);
}
