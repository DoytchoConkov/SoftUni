package com.softuni.springintroex.services.impl;

import com.softuni.springintroex.entities.Author;
import com.softuni.springintroex.repositories.AuthorRepository;
import com.softuni.springintroex.services.AuthorService;
import com.softuni.springintroex.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.softuni.springintroex.constants.GlobalConstants.AUTHOR_FILE_PATH;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;
@Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (this.authorRepository.count() != 0) {
            return;
        }
        String[] fileContent = this.fileUtil.readFileContent(AUTHOR_FILE_PATH);
        Arrays.stream(fileContent).forEach(r -> {
            String[] params = r.split("\\s+");
            Author author = new Author(params[0], params[1]);
            this.authorRepository.saveAndFlush(author);
        });
    }

    @Override
    public Author findAuthorById(long randomAuthorIndex) {
        return this.authorRepository.getOne(randomAuthorIndex);
    }

    @Override
    public int getAllAuthorsCount() {
        return (int) this.authorRepository.count();
    }

    @Override
    public void printAllAuthorWhichFirstNameEndsWith(String str) {
        this.authorRepository.findAllByFirstNameEndingWith(str)
                .forEach(a-> System.out.printf("%s %s%n",a.getFirstName(),a.getLastName()));
    }

    @Override
    public void printAllAuthorsAndSumOfCopies() {
        List<Author> authors = this.authorRepository.findAll();
        Map<String,Integer> mapAuthors= new HashMap<>();
        authors.forEach(a-> {
            int copies=a.getBooks().stream().mapToInt(b->b.getCopies()).sum();
            mapAuthors.put(a.getFirstName()+" "+a.getLastName(),copies);
        });
        mapAuthors.entrySet().stream().sorted((a,b)-> b.getValue().compareTo(a.getValue()))
                .forEach(a-> System.out.printf("%s - %d%n",a.getKey(),a.getValue()));
    }
}
