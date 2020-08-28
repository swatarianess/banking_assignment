package com.steve.banking_assignment.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AccountRetrievalControllerTest {
    MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", StandardCharsets.UTF_8);
    String exampleUserOne = "{\"customerID\": 111,  \"name\": \"steve\", \"surname\": \"adu\"}";
    String exampleUserTwo = "{\"customerID\": 222,  \"name\": \"bob\", \"surname\": \"bob\", \"balance\": 1000}} ";

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    AccountRegistrationController controller;

    @BeforeEach
    void setUp(WebApplicationContext webApplicationContext) throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        mockMvc.perform(post("/accounts/")
                .content(exampleUserOne)
                .accept(MEDIA_TYPE_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON))
        ;

        mockMvc.perform(post("/accounts/")
                .content(exampleUserTwo)
                .accept(MEDIA_TYPE_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON))
        ;
    }

    @Test
    @Tag("development")
    @Tag("retrieval")
    @DisplayName("Retrieving account based on UserID")
    void getAccountFromUserId() throws Exception {
        mockMvc.perform(get("/accounts/111")
                .accept(MEDIA_TYPE_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(jsonPath("$.name").value("steve"))
        ;
    }

    @Test
    @Tag("development")
    @Tag("registry")
    @DisplayName("Retrieving all accounts in the Account Registry")
    void getAllAccounts() throws Exception {
        mockMvc.perform(get("/accounts/")
                .accept(MEDIA_TYPE_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(jsonPath("$.*", hasSize(greaterThan(1))));
    }

    @Test
    @Tag("development")
    @Tag("exception")
    @Tag("registry")
    @DisplayName("Should throw account does not exist when retrieving non-existent account")
    void shouldThrowAccountNotFound() throws Exception {
        mockMvc.perform(get("/accounts/999999999")
                .accept(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string("Account not found!"))
        ;
    }

}