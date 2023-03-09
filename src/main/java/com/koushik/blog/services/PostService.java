package com.koushik.blog.services;

import java.util.List;

import com.koushik.blog.entities.Post;
import com.koushik.blog.payloads.PostDto;

public interface PostService {

	// create
	PostDto createPost(PostDto postDto, Integer UserId, Integer CategoryId);

	// update
	PostDto updatePost(PostDto postDto, Integer postId);

	// delete post
	void deletePost(Integer postId);

	// get all posts
	List<PostDto> getAllPosts(Integer pageNumber, Integer pageSize);

	//get single post
	PostDto getPostById(Integer postId);

	// get all posts by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all posts by user
	List<PostDto> getPostsByUser(Integer userId);
	
	//search posts
	List<Post> searchPosts(String keyword);
}
