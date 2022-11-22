package com.example.PracticalWorkPP.repository;

import com.example.PracticalWorkPP.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
