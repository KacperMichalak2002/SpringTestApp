package com.Kacper.database.services;

import com.Kacper.database.domain.entities.AuthorEntity;

import java.util.List;

public interface AuthorService {
    public AuthorEntity createAuthor(AuthorEntity authorEntity);

    List<AuthorEntity> findLAll();
}
