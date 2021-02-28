package com.softuni.springintroex.services.impl;

import com.softuni.springintroex.entities.*;
import com.softuni.springintroex.repositories.BookRepository;
import com.softuni.springintroex.services.AuthorService;
import com.softuni.springintroex.services.BookService;
import com.softuni.springintroex.services.CategoryService;
import com.softuni.springintroex.services.models.BookInfo;
import com.softuni.springintroex.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.softuni.springintroex.constants.GlobalConstants.BOOK_FILE_PATH;

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
            book.setAuthor(author);
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
    public void printAllBookWithAgeRestriction(String ageRestriction) {
        this.bookRepository.findAllByAgeRestrictionIs(AgeRestriction.valueOf(ageRestriction.toUpperCase()))
                .forEach(b-> System.out.printf("%s%n",b.getTitle()));
    }

    @Override
    public void printAllBooksWithGoldEditionAndLessCopies() {
        this.bookRepository.findAllByEditionTypeAndCopiesIsLessThan(EditionType.valueOf("GOLD"),5000)
                .forEach(b-> System.out.printf("%s%n",b.getTitle()));
    }

    @Override
    public void printAllBooksNotInRange() {
        this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5),BigDecimal.valueOf(40))
                .forEach(b-> System.out.printf("%s - $%s%n",b.getTitle(),b.getPrice()));
    }

    @Override
    public void printAllBookBeforeYear(String year) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate releaseDate = LocalDate.parse("01/01/"+year, formatter);
        this.bookRepository.findAllByReleaseDateLessThan(releaseDate)
                .forEach(b-> System.out.printf("%s %s $%s%n",b.getTitle(),b.getEditionType(),b.getPrice()));
    }

    @Override
    public void printAllBookBeforeDate(String realiseDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate releaseDate = LocalDate.parse(realiseDate, formatter);
        this.bookRepository.findAllByReleaseDateLessThan(releaseDate)
                .forEach(b-> System.out.printf("%s %s $%s%n",b.getTitle(),b.getEditionType(),b.getPrice()));
    }

    @Override
    public void printAllBooksContaining(String str) {
        this.bookRepository.findAllByTitleContains(str)
                .forEach(b-> System.out.printf("%s %s $%s%n",b.getTitle(),b.getEditionType(),b.getPrice()));
    }

    @Override
    public void printAllBooksWhichAuthorLastNameStartWith(String str) {
        this.bookRepository.findAllByAuthorLastNameStartingWith(str)
                .forEach(b-> System.out.printf("%s (%s %s)%n",b.getTitle(),b.getAuthor().getFirstName(),b.getAuthor().getLastName()));
    }

    @Override
    public void printBookCountWihtTitleLength(int length) {
        System.out.println(this.bookRepository.getNumberOfBooksWithTitleLength(length));
    }

    @Override
    public BookInfo findBookByTitle(String str) {
    Book book = this.bookRepository.findByTitle(str);
    BookInfo bookInfo=new BookInfo(book.getTitle(),book.getEditionType(),book.getPrice(),book.getAgeRestriction());
        return bookInfo;
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
