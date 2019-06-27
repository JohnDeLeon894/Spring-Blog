package com.codeup.springblog;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepo extends CrudRepository<Post, Long> {

    List<Post> findAll();

    Post findById(Long id);
}
