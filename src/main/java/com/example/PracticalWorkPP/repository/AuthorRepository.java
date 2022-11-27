package com.example.PracticalWorkPP.repository;

import com.example.PracticalWorkPP.models.Author;
import com.example.PracticalWorkPP.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    public List<Author> findByFirstname(String firstname);

}
