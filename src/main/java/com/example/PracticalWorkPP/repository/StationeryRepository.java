package com.example.PracticalWorkPP.repository;

import com.example.PracticalWorkPP.models.Category;
import com.example.PracticalWorkPP.models.Stationery;
import org.springframework.data.repository.CrudRepository;

public interface StationeryRepository extends CrudRepository<Stationery, Long> {

    Stationery findByName(String nameStationery);
}
