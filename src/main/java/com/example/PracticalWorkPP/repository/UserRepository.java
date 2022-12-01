package com.example.PracticalWorkPP.repository;

import com.example.PracticalWorkPP.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
