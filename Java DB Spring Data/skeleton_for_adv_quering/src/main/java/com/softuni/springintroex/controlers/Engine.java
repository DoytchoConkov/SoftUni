package com.softuni.springintroex.controlers;

import com.softuni.springintroex.services.AuthorService;
import com.softuni.springintroex.services.BookService;
import com.softuni.springintroex.services.CategoryService;
import com.softuni.springintroex.services.models.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class Engine implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public Engine(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        //Ex1 this.bookService.printAllBookWithAgeRestriction(reader.readLine());

        //Ex2  this.bookService.printAllBooksWithGoldEditionAndLessCopies();

        // Ex3 this.bookService.printAllBooksNotInRange();

        //Ex4   this.bookService.printAllBookBeforeYear(reader.readLine());

        //Ex5     this.bookService.printAllBookBeforeDate(reader.readLine());

        //Ex6   this.authorService.printAllAuthorWhichFirstNameEndsWith(reader.readLine());

      //Ex7  this.bookService.printAllBooksContaining(reader.readLine());

      //Ex8  this.bookService.printAllBooksWhichAuthorLastNameStartWith(reader.readLine());

      // Ex9 this.bookService.printBookCountWihtTitleLength(Integer.parseInt(reader.readLine()));

      //Ex10  this.authorService.printAllAuthorsAndSumOfCopies();

        BookInfo bookInfo= this.bookService.findBookByTitle(reader.readLine());
        System.out.printf("%s %s %s %s%n",bookInfo.getTitle(),bookInfo.getEditionType(),bookInfo.getAgeRestriction(), bookInfo.getPrice());

    }
}
