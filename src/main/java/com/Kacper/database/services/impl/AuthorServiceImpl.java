package com.Kacper.database.services.impl;

import com.Kacper.database.domain.entities.AuthorEntity;
import com.Kacper.database.repositories.AuthorRepository;
import com.Kacper.database.services.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;


    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }
}
