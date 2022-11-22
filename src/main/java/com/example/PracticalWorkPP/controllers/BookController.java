package com.example.PracticalWorkPP.controllers;

import com.example.PracticalWorkPP.models.Book;
import com.example.PracticalWorkPP.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Book> bookIterable = bookRepository.findAll();
        model.addAttribute("book_list", bookIterable);

        return "book/index";
    }

    @GetMapping("/add")
    public String addView() { return "book/add-book"; }

    @PostMapping("/add")
    public String addBook(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "genre") String genre,
            @RequestParam(name = "publishinghouse") String publishinghouse,
            @RequestParam(name = "placeofpublication") String placeofpublication,
            @RequestParam(name = "author") String author
    ){
        Book new_book = new Book(title, genre, publishinghouse, placeofpublication, author);
        bookRepository.save(new_book);

        return "redirect:/book/";
    }
}
