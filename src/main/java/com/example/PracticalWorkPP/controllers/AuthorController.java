package com.example.PracticalWorkPP.controllers;

import com.example.PracticalWorkPP.models.Author;
import com.example.PracticalWorkPP.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Author> bookIterable = authorRepository.findAll();
        model.addAttribute("author_list", bookIterable);

        return "author/index";
    }

    @GetMapping("/add")
    public String addView(@ModelAttribute("author") Author author) {
        return "author/add-author";
    }

    @PostMapping("/add")
    public String addAuthor(@ModelAttribute("author") @Valid Author author,
                            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "author/add-author";
        }
        authorRepository.save(author);
        return "redirect:/author/";
    }
    @GetMapping("/filter")
    public String filter(@RequestParam(name = "firstname") String firstname,
                         Model model) {
        List<Author> authorList = authorRepository.findByFirstname(firstname);
        model.addAttribute("author_list", authorList);

        return "author/index";
    }
    @GetMapping("/detail/{id}")
    public String detailAuthor(
            @PathVariable Long id,
            Model model
    ) {
        Author author = authorRepository.findById(id).orElseThrow();
        model.addAttribute("one_author", author);

        return "author/author-info";
    }
    @GetMapping("/detail/{id}/del")
    public String deleteAuthor(@PathVariable Long id) {
        Author author = authorRepository.findById(id).orElseThrow();
        authorRepository.delete(author);
        return "redirect:/author/";
    }
    @GetMapping("/detail/{id}/upd")
    public String updateView(
            @PathVariable Long id,
            Model model
    ) {
        Author res = authorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Неверный id: "+id));
        model.addAttribute("author", res);
        return "author/update-author";
    }
    @PostMapping("/detail/{id}/upd")
    public String updateView(
            @ModelAttribute("author") @Valid Author author, BindingResult bindingResult,
            @PathVariable Long id) {

        author.setUID(id);
        if (bindingResult.hasErrors()) {
            return "author/update-author";
        }
        authorRepository.save(author);
        return "redirect:/author/detail/" + author.getUID();
    }
}
