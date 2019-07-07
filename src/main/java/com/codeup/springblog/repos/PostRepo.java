package com.codeup.springblog.repos;

import com.codeup.springblog.model.Post;
import com.codeup.springblog.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepo extends CrudRepository<Post, Long> {

    List<Post> findAll();
    Post findById(Long id);

    List<Post> findAllByOwner(User user);

}
