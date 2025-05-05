package com.Kacper.database.repositories;

import com.Kacper.database.TestDataUtil;
import com.Kacper.database.domain.Author;
import com.Kacper.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryIntegrationTests {

    private BookRepository underTest;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    public BookRepositoryIntegrationTests(BookRepository underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled(){
        Author author = authorRepository.save(TestDataUtil.createTestAuthorA());
        Book book = TestDataUtil.createTestBookA(author);
        underTest.save(book);

        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled(){
        Author author = authorRepository.save(TestDataUtil.createTestAuthorA());

        Book bookA = TestDataUtil.createTestBookA(author);
        underTest.save(bookA);

        Book bookB = TestDataUtil.createTestBookB(author);
        underTest.save(bookB);

        Book bookC = TestDataUtil.createTestBookC(author);
        underTest.save(bookC);

        Iterable<Book> result = underTest.findAll();
        assertThat(result)
                .hasSize(3)
                .containsExactly(bookA, bookB, bookC);

    }

//    @Test
//    public void testThatBookCanBeUpdated(){
//        Author author = TestDataUtil.createTestAuthorA();
//        authorDao.create(author);
//
//        Book bookA = TestDataUtil.createTestBookA();
//        bookA.setAuthor_id(author.getId());
//        underTest.create(bookA);
//
//        bookA.setTitle("UPDATED");
//        underTest.update(bookA.getIsbn(),bookA);
//
//        Optional<Book> result = underTest.findOne(bookA.getIsbn());
//        assertThat(result).isPresent();
//        Book actualBook = result.get();
//        assertThat(actualBook.getIsbn()).isEqualTo(bookA.getIsbn());
//        assertThat(actualBook.getTitle()).isEqualTo(bookA.getTitle());
//        assertThat(actualBook.getAuthor_id()).isEqualTo(bookA.getAuthor_id());
//    }
//
//    @Test
//    public void testThatBookCanBeDeleted(){
//        Author author = TestDataUtil.createTestAuthorA();
//        authorDao.create(author);
//
//        Book bookA = TestDataUtil.createTestBookA();
//        bookA.setAuthor_id(author.getId());
//        underTest.create(bookA);
//
//        underTest.delete(bookA.getIsbn());
//        Optional <Book> result = underTest.findOne(bookA.getIsbn());
//        assertThat(result).isEmpty();
//    }

}
