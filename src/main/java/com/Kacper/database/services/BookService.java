package com.Kacper.database.services;

import com.Kacper.database.domain.entities.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {

     BookEntity createUpdateBook(String isbn, BookEntity book);

    List<BookEntity> findAll();

    Optional<BookEntity> findOne(String isbn);

    boolean isExist(String isbn);

    BookEntity paritalUpdate(String isbn, BookEntity bookEntity);

    void delete(String isbn);
}
