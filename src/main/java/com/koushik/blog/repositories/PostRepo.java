package com.koushik.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.koushik.blog.entities.Category;
import com.koushik.blog.entities.Post;
import com.koushik.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	// the following are custom methods we give, but even without their definition(implementation)
	// they are working
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);
	
	//same findbytitle can be implemented by custom query as below
	@Query("select p from Post p where p.title like :key")
	List<Post> searchByTitle(@Param("key") String title);

}
