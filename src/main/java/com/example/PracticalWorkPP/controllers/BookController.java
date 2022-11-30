package com.example.PracticalWorkPP.controllers;

import com.example.PracticalWorkPP.models.Author;
import com.example.PracticalWorkPP.models.Book;
import com.example.PracticalWorkPP.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public String addView(@ModelAttribute("book") Book book) {
        return "book/add-book";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "book/add-book";
        }
        bookRepository.save(book);
        return "redirect:/book/";
    }
    @GetMapping("/filter")
    public String filter(@RequestParam(name = "title") String title,
                         Model model) {
        List<Book> bookList = bookRepository.findByTitle(title);
        model.addAttribute("book_list", bookList);

        return "book/index";
    }
    @GetMapping("/detail/{id}")
    public String detailBook(
            @PathVariable Long id,
            Model model
    ) {
        Book book = bookRepository.findById(id).orElseThrow();
        model.addAttribute("one_book", book);

        return "book/book-info";
    }
    @GetMapping("/detail/{id}/del")
    public String deleteBook(@PathVariable Long id,
                             Model model) {
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);
//        starRepository.deleteById(id);
        return "redirect:/book/";
    }
    @GetMapping("/detail/{id}/upd")
    public String updateView(
            @PathVariable Long id,
            Model model
    ) {
        Book res = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Неверный id: "+id));
        model.addAttribute("book", res);
        return "book/update-book";
    }
    @PostMapping("/detail/{id}/upd")
    public String updateView(
            @ModelAttribute("book") @Valid Book book, BindingResult bindingResult,
            @PathVariable Long id) {

        book.setUID(id);
        if (bindingResult.hasErrors()) {
            return "book/update-book";
        }
        bookRepository.save(book);
        return "redirect:/book/detail/" + book.getUID();
    }
}
