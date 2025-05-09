package com.Kacper.database.controllers;

import com.Kacper.database.TestDataUtil;
import com.Kacper.database.domain.dto.BookDto;
import com.Kacper.database.domain.entities.BookEntity;
import com.Kacper.database.services.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc

public class BookControllerIntegrationTest {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private BookService bookService;

    @Autowired
    public BookControllerIntegrationTest(MockMvc mockMvc, BookService bookService) {
        this.mockMvc = mockMvc;
        this.objectMapper = new ObjectMapper();
        this.bookService = bookService;
    }

    @Test
    public void testThatCreateUpdateBookReturnsHttpStatus201Created() throws Exception{
        BookDto bookDto = TestDataUtil.createTestBookDtoA(null);
        String createBookJson = objectMapper.writeValueAsString(bookDto);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/books/" + bookDto.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createBookJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );
    }

    @Test
    public void testThatCreateBookReturnsCreatedUpdateBook() throws Exception{
        BookDto bookDto = TestDataUtil.createTestBookDtoA(null);
        String createBookJson = objectMapper.writeValueAsString(bookDto);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/books/" + bookDto.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createBookJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.isbn").value(bookDto.getIsbn())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.title").value(bookDto.getTitle())
        );
    }

    @Test
    public void testThatListBooksReturnsHttpStatus200Ok() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/books")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }


    @Test
    public void testThatListBooksReturnsBook() throws Exception{

        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);
        bookService.createUpdateBook(testBookEntityA.getIsbn(), testBookEntityA);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/books")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].isbn").value("987-123-456-8")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].title").value("The shadown in the attic")
        );
    }

    @Test
    public void testThatGetBookReturnsHttpStatus200WhenBookExist() throws Exception{
        BookEntity bookEntity = TestDataUtil.createTestBookEntityA(null);
        bookService.createUpdateBook(bookEntity.getIsbn(), bookEntity);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/books/"  + bookEntity.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    public void testThatGetBookReturnsHttpStatus404WhenNoBookExist() throws Exception{
        BookEntity bookEntity = TestDataUtil.createTestBookEntityA(null);
        bookService.createUpdateBook(bookEntity.getIsbn(), bookEntity);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/books/987-123-456-8123")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isNotFound()
        );
    }

    @Test
    public void testThatGetBookReturnsBookWhenNoBookExist() throws Exception{
        BookEntity bookEntity = TestDataUtil.createTestBookEntityA(null);
        bookService.createUpdateBook(bookEntity.getIsbn(), bookEntity);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/books/" + bookEntity.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.isbn").value("987-123-456-8")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.title").value("The shadown in the attic")
        );
    }

    @Test
    public void testThatUpdateBookReturnHttpsStatus200Ok() throws Exception{
        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);
        BookEntity savedBookEntity = bookService.createUpdateBook(testBookEntityA.getIsbn(), testBookEntityA);

        BookDto testBookDtoA = TestDataUtil.createTestBookDtoA(null);
        testBookDtoA.setIsbn(savedBookEntity.getIsbn());
        String bookJson = objectMapper.writeValueAsString(testBookDtoA);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/books/" + testBookDtoA.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    public void testThatUpdateBookReturnsUpdatedBook() throws Exception{
        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);
        BookEntity savedBookEntity = bookService.createUpdateBook(testBookEntityA.getIsbn(), testBookEntityA);

        BookDto testBookDtoA = TestDataUtil.createTestBookDtoA(null);
        testBookDtoA.setIsbn(savedBookEntity.getIsbn());
        testBookDtoA.setTitle("UPDATED");
        String bookJson = objectMapper.writeValueAsString(testBookDtoA);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/books/" + testBookDtoA.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.isbn").value(testBookDtoA.getIsbn())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.title").value("UPDATED")
        );
    }

    @Test
    public void testThatPartialUpdateBookReturnHttpStatus200Ok() throws Exception{

        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);
        bookService.createUpdateBook(testBookEntityA.getIsbn(),testBookEntityA);
        BookDto testBookDtoA = TestDataUtil.createTestBookDtoA(null);

        testBookDtoA.setTitle("UPDATED");
        String bookJson = objectMapper.writeValueAsString(testBookDtoA);

        mockMvc.perform(
                MockMvcRequestBuilders.patch("/books/" + testBookDtoA.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    public void testThatPartialUpdateBookReturnUpdatedBook() throws Exception{

        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);
        bookService.createUpdateBook(testBookEntityA.getIsbn(),testBookEntityA);
        BookDto testBookDtoA = TestDataUtil.createTestBookDtoA(null);

        testBookDtoA.setTitle("UPDATED");
        String bookJson = objectMapper.writeValueAsString(testBookDtoA);

        mockMvc.perform(
                MockMvcRequestBuilders.patch("/books/" + testBookDtoA.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.isbn").value(testBookDtoA.getIsbn())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.title").value("UPDATED")
        );
    }


}
