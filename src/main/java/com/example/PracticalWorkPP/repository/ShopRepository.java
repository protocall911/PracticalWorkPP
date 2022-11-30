package com.example.PracticalWorkPP.repository;

import com.example.PracticalWorkPP.models.Shop;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<Shop, Long> {
    Shop findByName(String nameShop);
}
