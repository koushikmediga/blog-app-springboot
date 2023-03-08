package com.koushik.blog.services;

import java.util.List;

import com.koushik.blog.entities.Post;
import com.koushik.blog.payloads.PostDto;

public interface PostService {

	// create
	PostDto createPost(PostDto postDto, Integer UserId, Integer CategoryId);

	// update
	Post updatePost(PostDto postDto, Integer postId);

	// delete post
	void deletePost(Integer postId);

	// get all posts
	List<Post> getAllPosts();

	//get single post
	Post getPostById(Integer postId);

	// get all posts by category
	List<Post> getPostsByCategory(Integer categoryId);
	
	//get all posts by user
	List<Post> getPostsByUser(Integer userId);
	
	//search posts
	List<Post> searchPosts(String keyword);
}
