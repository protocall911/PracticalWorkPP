package com.example.PracticalWorkPP.repository;

import com.example.PracticalWorkPP.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    public List<Book> findByTitle(String title);
}
