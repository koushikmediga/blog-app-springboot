package com.koushik.blog.services;

import java.util.List;

import com.koushik.blog.entities.Post;
import com.koushik.blog.payloads.PostDto;
import com.koushik.blog.payloads.PostResponse;

public interface PostService {

	// create
	PostDto createPost(PostDto postDto, Integer UserId, Integer CategoryId);

	// update
	PostDto updatePost(PostDto postDto, Integer postId);

	// delete post
	void deletePost(Integer postId);

	// get all posts
	PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

	// get single post
	PostDto getPostById(Integer postId);

	// get all posts by category
	List<PostDto> getPostsByCategory(Integer categoryId);

	// get all posts by user
	List<PostDto> getPostsByUser(Integer userId);

	// search posts
	List<PostDto> searchPosts(String keyword);

	// search posts custom method
	List<PostDto> searchPosts2(String keyword);
}
