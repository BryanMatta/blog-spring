package com.codeup.blog.repositories;

import com.codeup.blog.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

        // get a post at random
        @Query(value="SELECT * FROM posts ORDER BY RAND() LIMIT 1", nativeQuery = true)
        Post getRandom();


}

