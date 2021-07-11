package com.act.controller;

import com.act.BooksApplication;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = BooksApplication.class)
@AutoConfigureMockMvc
public abstract class AbstractTest {

    @Autowired
    protected MockMvc mvc;

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    protected <T> T mapFromJson(MvcResult result, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        String resultAsString = result.getResponse().getContentAsString();
        return objectMapper.readValue(resultAsString, clazz);
    }

    protected <T> List<T> mapListFromJson(MvcResult result, Class<T> clazz)
            throws IOException, ClassNotFoundException, JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        String resultAsString = result.getResponse().getContentAsString();
        //return objectMapper.readValue(resultAsString, objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
        Class<T[]> arrayClass = (Class<T[]>) Class.forName("[L" + clazz.getName() + ";");
        T[] objects = objectMapper.readValue(resultAsString, arrayClass);
        return Arrays.asList(objects);
    }

    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }

}
