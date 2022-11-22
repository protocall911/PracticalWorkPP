package com.example.PracticalWorkPP.controllers;

import com.example.PracticalWorkPP.models.Author;
import com.example.PracticalWorkPP.models.Book;
import com.example.PracticalWorkPP.repository.AuthorRepository;
import com.example.PracticalWorkPP.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

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
    public String addView() { return "author/add-author"; }

    @PostMapping("/add")
    public String addAuthor(
            @RequestParam(name = "lastname") String lastname,
            @RequestParam(name = "firstname") String firstname,
            @RequestParam(name = "middlename") String middlename,
            @RequestParam(name = "birthday") Date birthday,
            @RequestParam(name = "totalworks") Integer totalworks
    ){
        Author new_author = new Author(lastname, firstname, middlename, birthday, totalworks);
        authorRepository.save(new_author);

        return "redirect:/author/";
    }
}
