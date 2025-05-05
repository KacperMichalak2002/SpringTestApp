package com.Kacper.database.dao.impl;


import com.Kacper.database.TestDataUtil;
import com.Kacper.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreateBookGenereatesCorrectSql(){
        Book book = TestDataUtil.createTestBookA();
        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, author_id) VALUES(?, ?, ?)"),
                eq("987-123-456-8"),eq("The shadown in the attic"),eq(1L)
        );
    }


    @Test
    public void testThatFindOneGeneratesTheCorrectSql(){
        underTest.findOne("987-123-456-8");

        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("987-123-456-8")
        );
    }

    @Test
    public void testThatFindManyGeneratesTheCorrrectSq(){
        underTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books"),
                        ArgumentMatchers.<BookDaoImpl.BookRowMapper>any()
        );
    }

    @Test
    public void testThatUpdateGeneratesCorrectSql(){
        Book book = TestDataUtil.createTestBookA();
        underTest.update("987-123-456-8", book);
        verify(jdbcTemplate).update(
                eq("UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?"),
                eq("987-123-456-8"),eq("The shadown in the attic"),eq(1L),eq("987-123-456-8")
        );
    }

    @Test
    public void testThatDeleteGenereatesCorrectSql(){
        underTest.delete("987-123-456-8");
        verify(jdbcTemplate).update(
                eq("DELETE FROM books WHERE isbn = ?"),
                eq("987-123-456-8")
        );
    }
}
