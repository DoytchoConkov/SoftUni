package com.example.spring_data_intro.services;

import com.example.spring_data_intro.entities.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    int getAllAuthorsCount();

    Author findAuthorById(long randomAuthorIndex);
    List<Author> findAllAuthorsByBookCount();
}
