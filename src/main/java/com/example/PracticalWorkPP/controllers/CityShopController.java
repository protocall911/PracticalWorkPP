package com.example.PracticalWorkPP.controllers;

import com.example.PracticalWorkPP.models.City;
import com.example.PracticalWorkPP.models.Shop;
import com.example.PracticalWorkPP.repository.CityRepository;
import com.example.PracticalWorkPP.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CityShopController {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private ShopRepository shopRepository;

    @GetMapping("/shop")
    private String Main(Model model){
        Iterable<City> cities = cityRepository.findAll();
        model.addAttribute("cities", cities);
        Iterable<Shop> shops = shopRepository.findAll();
        model.addAttribute("shops", shops);

        return "shop/index";
    }
    @PostMapping("/shop/add")
    public String blogPostAdd(@RequestParam String nameShop, @RequestParam String nameCity, Model model)
    {
        City city = cityRepository.findByName(nameCity);
        Shop shop = shopRepository.findByName(nameShop);

        city.getShops().add(shop);
        cityRepository.save(city);

        return "redirect:/shop";
    }

}
