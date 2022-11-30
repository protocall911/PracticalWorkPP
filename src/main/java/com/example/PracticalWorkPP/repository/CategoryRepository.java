package com.example.PracticalWorkPP.repository;

import com.example.PracticalWorkPP.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findByNameCategory(String nameCategory);
}
