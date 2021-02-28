package com.example.spring_data_intro.services.impl;

import com.example.spring_data_intro.entities.Author;
import com.example.spring_data_intro.repesitories.AuthorRepository;
import com.example.spring_data_intro.services.AuthorService;
import com.example.spring_data_intro.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.example.spring_data_intro.constants.GlobalConstants.AUTHOR_FILE_PATH;

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
    public int getAllAuthorsCount() {
        return (int) this.authorRepository.count();
    }

    @Override
    public Author findAuthorById(long randomAuthorIndex) {
        return this.authorRepository.getOne(randomAuthorIndex);
    }

    @Override
    public List<Author> findAllAuthorsByBookCount() {
        return this.authorRepository.findAuthorByCountOfBooks();
    }
}
