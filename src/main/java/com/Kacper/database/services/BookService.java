package com.Kacper.database.services;

import com.Kacper.database.domain.entities.BookEntity;

public interface BookService {

     BookEntity createBook(String isbn, BookEntity book);
}
