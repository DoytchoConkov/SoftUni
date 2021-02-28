package com.softuni.springintroex.services;

import com.softuni.springintroex.services.models.BookInfo;

import java.io.IOException;

public interface BookService {

    void seedBooks() throws IOException;

    void printAllBookWithAgeRestriction(String ageRestriction);

    void printAllBooksWithGoldEditionAndLessCopies();

    void printAllBooksNotInRange();

    void printAllBookBeforeYear(String year);

    void printAllBookBeforeDate(String realiseDate);

    void printAllBooksContaining(String str);

    void printAllBooksWhichAuthorLastNameStartWith(String str);

    void printBookCountWihtTitleLength(int length);

    BookInfo findBookByTitle(String str);
}
