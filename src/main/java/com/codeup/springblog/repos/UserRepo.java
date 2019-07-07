package com.codeup.springblog.repos;

import com.codeup.springblog.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {

    List<User> findAll();
    User findByName(String name);
    User findById(Long id);

}
