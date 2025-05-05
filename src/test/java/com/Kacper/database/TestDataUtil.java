package com.Kacper.database;

import com.Kacper.database.domain.Author;
import com.Kacper.database.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){

    }

    public static Author createTestAuthorA() {
        Author author = new Author();
        author.setId(1L);
        author.setName("Abigail Rose");
        author.setAge(80);
        return author;
    }

    public static Author createTestAuthorB() {
        Author author = new Author();
        author.setId(2L);
        author.setName("Thomas Cronin");
        author.setAge(44);
        return author;
    }

    public static Author createTestAuthorC() {
        Author author = new Author();
        author.setId(3L);
        author.setName("Jesse A Casey");
        author.setAge(24);
        return author;
    }

    public static Book createTestBookA() {
        Book book = new Book();
        book.setIsbn("987-123-456-8");
        book.setTitle("The shadown in the attic");
        book.setAuthor_id(1L);
        return book;
    }

    public static Book createTestBookB() {
        Book book = new Book();
        book.setIsbn("987-123-456-38");
        book.setTitle("Beyond the Horizon");
        book.setAuthor_id(2L);
        return book;
    }

    public static Book createTestBookC() {
        Book book = new Book();
        book.setIsbn("987-123-456-85");
        book.setTitle("The Last Ember");
        book.setAuthor_id(3L);
        return book;
    }
}
