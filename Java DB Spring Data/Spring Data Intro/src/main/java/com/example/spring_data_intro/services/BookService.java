package com.example.spring_data_intro.services;

import com.example.spring_data_intro.entities.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;
    List<Book> getAllBookAfter2000();
}
