package com.example.spring_data_intro.services.impl;

import com.example.spring_data_intro.entities.*;
import com.example.spring_data_intro.repesitories.BookRepository;
import com.example.spring_data_intro.services.AuthorService;
import com.example.spring_data_intro.services.BookService;
import com.example.spring_data_intro.services.CategoryService;
import com.example.spring_data_intro.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.example.spring_data_intro.constants.GlobalConstants.BOOK_FILE_PATH;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final FileUtil fileUtil;
    private final AuthorService authorService;
    private  final CategoryService categoryService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, FileUtil fileUtil, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.fileUtil = fileUtil;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (this.bookRepository.count() != 0) {
            return;
        }
        String[] fileContent = this.fileUtil.readFileContent(BOOK_FILE_PATH);
        Arrays.stream(fileContent).forEach(r -> {
            String[] params = r.split("\\s+", 6);
            Author author = getRandomAuthor();
            EditionType editionType = EditionType.values()[Integer.parseInt(params[0])];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate releaseDate = LocalDate.parse(params[1], formatter);
            int copies = Integer.parseInt(params[2]);
            BigDecimal price = new BigDecimal(params[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(params[4])];
            String title = params[5];
            Set<Category> categories = this.getRandomCategories();

            Book book = new Book();
            book.setAutor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            book.setCategories(categories);
            this.bookRepository.saveAndFlush(book);
        });
    }

    @Override
    public List<Book> getAllBookAfter2000() {
        LocalDate localDate=LocalDate.of(2000,12,31);
        return this.bookRepository.findByReleaseDateAfter(localDate);
    }

    private Set<Category> getRandomCategories() {
        Random random = new Random();
        Set<Category> categories = new LinkedHashSet<>();
        int categoryCount= random.nextInt(3)+1;
        for (int i = 0; i < categoryCount; i++) {
            int categoryRandomId=random.nextInt(8)+1;
            categories.add(this.categoryService.findRandomCategory(categoryRandomId));
        }
        return categories;
    }

    private Author getRandomAuthor() {
        Random random = new Random();
        int randomAuthorIndex = random.nextInt( this.authorService.getAllAuthorsCount()) + 1;
        return this.authorService.findAuthorById((long)randomAuthorIndex);
    }
}
