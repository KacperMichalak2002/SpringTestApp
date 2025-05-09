package com.Kacper.database.services;

import com.Kacper.database.domain.entities.AuthorEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    public AuthorEntity save(AuthorEntity authorEntity);

    List<AuthorEntity> findLAll();

    Optional<AuthorEntity> findOne(Long id);

    boolean isExists(Long id);
}
