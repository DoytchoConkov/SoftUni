package com.example.spring_data_intro.controlers;

import com.example.spring_data_intro.entities.Author;
import com.example.spring_data_intro.entities.Book;
import com.example.spring_data_intro.services.AuthorService;
import com.example.spring_data_intro.services.BookService;
import com.example.spring_data_intro.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

@Controller
public class AppControler implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public AppControler(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws IOException {
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();

        List<Book> books = this.bookService.getAllBookAfter2000();
        List<Author> authors = this.authorService.findAllAuthorsByBookCount();
        authors.forEach(a -> System.out.println(a.getBooks().size()));
        System.out.println();
    }
}
