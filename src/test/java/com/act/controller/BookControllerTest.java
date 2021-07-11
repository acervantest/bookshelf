package com.act.controller;

import com.act.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class BookControllerTest extends AbstractTest {

    @Test
    void findAllBooks() throws Exception {

        MvcResult response = mvc.perform( get("/api/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").isString())
                .andExpect(status().isOk())
                .andReturn();

        List<Book> books = mapListFromJson(response, Book.class);

        for(Book b: books) System.out.println(b);
    }

}