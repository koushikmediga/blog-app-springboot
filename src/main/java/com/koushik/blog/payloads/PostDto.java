package com.koushik.blog.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.koushik.blog.entities.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	private Integer postId;
	
	private String title; 
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	//same reason to use dto as in user
	private CategoryDto category;
	
	//here we are giving dto but not category because if we give user class it will go into infinite loop
	//and keep on creating posts as a user will again have array of posts
	private UserDto user;
	
	private Set<CommentDto> comments = new HashSet<>();
		
}
