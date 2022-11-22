package com.example.PracticalWorkPP.repository;

import com.example.PracticalWorkPP.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
