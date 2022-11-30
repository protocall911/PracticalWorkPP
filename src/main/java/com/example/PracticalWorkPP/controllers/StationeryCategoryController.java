package com.example.PracticalWorkPP.controllers;

import com.example.PracticalWorkPP.models.Category;
import com.example.PracticalWorkPP.models.Stationery;
import com.example.PracticalWorkPP.repository.CategoryRepository;
import com.example.PracticalWorkPP.repository.StationeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StationeryCategoryController {
    @Autowired
    public StationeryRepository stationeryRepository;
    @Autowired
    public CategoryRepository categoryRepository;

    @GetMapping("/stationery")
    public String index(Model model) {
        Iterable<Category> categories = categoryRepository.findAll();
        Iterable<Stationery> stationeries = stationeryRepository.findAll();
        model.addAttribute("category", categories);
        model.addAttribute("stationery", stationeries);
        return "stationery/index";
    }

    @PostMapping("/stationery/add")
    public String stationeryAdd(@RequestParam String name,
                                @RequestParam String nameCategory,
                                Model model) {
        Category category = categoryRepository.findByNameCategory(nameCategory);
        Stationery stationery = new Stationery(name, category);
        stationeryRepository.save(stationery);
        return "redirect:/stationery";
    }
}
