//package com.Kacper.database.repositories;
//
//import com.Kacper.database.TestDataUtil;
//import com.Kacper.database.domain.Author;
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
//import static org.assertj.core.api.AssertionsForClassTypes.tuple;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class AuthorDaoImplIntegrationTests {
//
//    private AuthorDaoImpl underTest;
//
//    @Autowired
//    public AuthorDaoImplIntegrationTests(AuthorDaoImpl underTest){
//        this.underTest = underTest;
//    }
//
//    @Test
//    public void testThatAuthorCanBeCreatedAndRecalled(){
//
//        Author author = TestDataUtil.createTestAuthorA();
//        underTest.create(author);
//        Optional<Author> result = underTest.findOne(author.getId());
//        assertThat(result).isPresent();
//        Author actualAuthor = result.get();
//        assertThat(actualAuthor.getId()).isEqualTo(author.getId());
//        assertThat(actualAuthor.getName()).isEqualTo(author.getName());
//        assertThat(actualAuthor.getAge()).isEqualTo(author.getAge());
//    }
//
//    @Test
//    public void testThatMultipleAuthorsCanBeCreatedAndRecalled(){
//        Author authorA = TestDataUtil.createTestAuthorA();
//        underTest.create(authorA);
//        Author authorB = TestDataUtil.createTestAuthorB();
//        underTest.create(authorB);
//        Author authorC = TestDataUtil.createTestAuthorC();
//        underTest.create(authorC);
//
//        List<Author> result =  underTest.find();
//        assertThat(result).hasSize(3);
//        assertThat(result).extracting(Author::getId, Author::getName, Author::getAge).containsExactly(
//                tuple(authorA.getId(), authorA.getName(), authorA.getAge()),
//                tuple(authorB.getId(), authorB.getName(), authorB.getAge()),
//                tuple(authorC.getId(), authorC.getName(), authorC.getAge())
//        );
//    }
//
//    @Test
//    public void testThatAuthorCanBeUpdated(){
//        Author authorA = TestDataUtil.createTestAuthorA();
//        underTest.create(authorA);
//        authorA.setName("UPDATED");
//        underTest.update(authorA.getId(), authorA);
//        Optional<Author> result = underTest.findOne(authorA.getId());
//        assertThat(result).isPresent();
//        Author actualAuthor = result.get();
//        assertThat(actualAuthor.getId()).isEqualTo(authorA.getId());
//        assertThat(actualAuthor.getName()).isEqualTo(authorA.getName());
//        assertThat(actualAuthor.getAge()).isEqualTo(authorA.getAge());
//
//    }
//
//    @Test
//    public void testThatAuthorCanBeDeleted(){
//        Author authorA = TestDataUtil.createTestAuthorA();
//        underTest.create(authorA);
//        underTest.delete(authorA.getId());
//        Optional<Author> result = underTest.findOne(authorA.getId());
//        assertThat(result).isEmpty();
//    }
//}
