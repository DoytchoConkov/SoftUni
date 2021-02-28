package com.softuni.springintroex.services;

import com.softuni.springintroex.entities.Author;

import java.io.IOException;

public interface AuthorService {

    void seedAuthors() throws IOException;

    Author findAuthorById(long randomAuthorIndex);

    int getAllAuthorsCount();

    void printAllAuthorWhichFirstNameEndsWith(String str);

    void printAllAuthorsAndSumOfCopies();
}
