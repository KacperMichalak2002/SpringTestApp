package com.Kacper.database;

import com.Kacper.database.domain.entities.AuthorEntity;
import com.Kacper.database.domain.entities.BookEntity;

public final class TestDataUtil {
    private TestDataUtil(){

    }

    public static AuthorEntity createTestAuthorA() {
        return AuthorEntity.builder()
                //.id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }

    public static AuthorEntity createTestAuthorB() {
        return AuthorEntity.builder()
                //.id(2L)
                .name("Thomas Cronin")
                .age(44)
                .build();
    }

    public static AuthorEntity createTestAuthorC() {
        return AuthorEntity.builder()
                //.id(3L)
                .name("Jesse A Casey")
                .age(24)
                .build();
    }

    public static BookEntity createTestBookA(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("987-123-456-8")
                .title("The shadown in the attic")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity createTestBookB(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("987-123-456-38")
                .title("Beyond the Horizon")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity createTestBookC(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("987-123-456-85")
                .title("The Last Ember")
                .authorEntity(authorEntity)
                .build();
    }
}
