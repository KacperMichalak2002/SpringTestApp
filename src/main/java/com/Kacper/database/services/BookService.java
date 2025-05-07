package com.Kacper.database.services;

import com.Kacper.database.domain.dto.BookDto;
import com.Kacper.database.domain.entities.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {

     BookEntity createBook(String isbn, BookEntity book);

    List<BookEntity> findAll();

    Optional<BookEntity> findOne(String isbn);
}
