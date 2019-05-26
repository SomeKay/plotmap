package com.poslek.plotmap.web.controllers;

import com.poslek.plotmap.web.models.Book;
import com.poslek.plotmap.web.services.BooksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("search/{query}")
    public List<Book> search(@PathVariable String query) {
        return this.booksService.search(query);
    }

}
