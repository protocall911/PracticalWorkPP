package com.example.PracticalWorkPP.repository;

import com.example.PracticalWorkPP.models.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
    City findByName(String nameCity);
}
