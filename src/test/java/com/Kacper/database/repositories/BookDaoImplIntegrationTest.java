//package com.Kacper.database.repositories;
//
//import com.Kacper.database.TestDataUtil;
//import com.Kacper.database.dao.AuthorDao;
//import com.Kacper.database.domain.Author;
//import com.Kacper.database.domain.Book;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.tuple;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class BookDaoImplIntegrationTest {
//
//
//    private AuthorDao authorDao;
//    private BookDaoImpl underTest;
//
//    @Autowired
//    public BookDaoImplIntegrationTest(BookDaoImpl underTest, AuthorDao authorDao){
//        this.underTest = underTest;
//        this.authorDao = authorDao;
//    }
//
//    @Test
//    public void testThatBookCanBeCreatedAndRecalled(){
//        Author author = TestDataUtil.createTestAuthorA();
//        authorDao.create(author);
//        Book book = TestDataUtil.createTestBookA();
//        book.setAuthor_id(author.getId());
//        underTest.create(book);
//        Optional<Book> result = underTest.findOne(book.getIsbn());
//        assertThat(result).isPresent();
//        Book actualBook = result.get();
//        assertThat(actualBook.getIsbn()).isEqualTo(book.getIsbn());
//        assertThat(actualBook.getTitle()).isEqualTo(book.getTitle());
//        assertThat(actualBook.getAuthor_id()).isEqualTo(book.getAuthor_id());
//
//    }
//
//    @Test
//    public void testThatMultipleBooksCanBeCreatedAndRecalled(){
//        Author author = TestDataUtil.createTestAuthorA();
//        authorDao.create(author);
//        Book bookA = TestDataUtil.createTestBookA();
//        bookA.setAuthor_id(author.getId());
//        underTest.create(bookA);
//
//        Book bookB = TestDataUtil.createTestBookB();
//        bookB.setAuthor_id(author.getId());
//        underTest.create(bookB);
//
//        Book bookC = TestDataUtil.createTestBookC();
//        bookC.setAuthor_id(author.getId());
//        underTest.create(bookC);
//
//        List<Book> result = underTest.find();
//        assertThat(result).hasSize(3);
//        assertThat(result).extracting(Book::getIsbn, Book::getTitle, Book::getAuthor_id).containsExactly(
//                tuple(bookA.getIsbn(), bookA.getTitle(), bookA.getAuthor_id()),
//                tuple(bookB.getIsbn(), bookB.getTitle(), bookB.getAuthor_id()),
//                tuple(bookC.getIsbn(), bookC.getTitle(), bookC.getAuthor_id())
//
//        );
//
//
//    }
//
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
//
//}
