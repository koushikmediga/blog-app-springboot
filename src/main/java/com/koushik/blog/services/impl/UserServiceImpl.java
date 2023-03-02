package com.koushik.blog.services.impl;
import com.koushik.blog.repositories.UserRepo;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koushik.blog.entities.User;
import com.koushik.blog.payloads.UserDto;
import com.koushik.blog.services.UserService;
import com.koushik.blog.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = this.dtoToUser(userDto);
		
		User savedUser = this.userRepo.save(user);
		
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updatUser(UserDto userDto, Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," id ", userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		return userDto1;

	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," id ", userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users = this.userRepo.findAll();
		
		//need to check this stream collection
		List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," id ", userId));
		
		this.userRepo.delete(user);
	}
	
	//function to convert user dto to user object
	private User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		
		// the following is used when model mapper was not used
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		return user;
	}
	
	
	//function to convert user object to user dto
	private UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}
	

}
