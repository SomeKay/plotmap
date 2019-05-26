package com.poslek.plotmap.web.services;

import com.poslek.plotmap.web.models.Book;

import java.util.List;

public interface BooksService {
    public List<Book> search(String query);
}
