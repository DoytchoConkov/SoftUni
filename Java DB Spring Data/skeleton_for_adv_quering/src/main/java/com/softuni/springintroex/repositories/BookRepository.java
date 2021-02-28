package com.softuni.springintroex.repositories;

import com.softuni.springintroex.entities.AgeRestriction;
import com.softuni.springintroex.entities.Author;
import com.softuni.springintroex.entities.Book;
import com.softuni.springintroex.entities.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Set<Book> findAllByAgeRestrictionIs(AgeRestriction ageRestriction);

    Set<Book> findAllByEditionTypeAndCopiesIsLessThan(EditionType editionType, int copies);

    Set<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lowerPrice, BigDecimal upperPrice);

    Set<Book> findAllByReleaseDateLessThan(LocalDate date);

    Set<Book> findAllByTitleContains(String str);

    Set<Book> findAllByAuthorLastNameStartingWith(String str);

    @Query("SELECT count (b) FROM Book b WHERE length(b.title) > :length")
    int getNumberOfBooksWithTitleLength(int length);

    Book findByTitle(String str);

}
