package com.steve.banking_assignment.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class TransactionRegistrationControllerTest {
    MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", StandardCharsets.UTF_8);
    String exampleTransaction  = "{\"recipientCustomerID\": 1,  \"senderCustomerID\": 2, \"amount\": 100}";
    String exampleTransaction2 = "{\"recipientCustomerID\": 2,  \"senderCustomerID\": 3, \"amount\": 1000}";

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    TransactionRegistrationController controller;

    @BeforeEach
    void setUp(WebApplicationContext webApplicationContext) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void registerTransaction() throws Exception {

        mockMvc.perform(post("/transactions/")
                .content(exampleTransaction)
                .accept(MEDIA_TYPE_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(jsonPath("$.recipientCustomerID").value(1))
                .andExpect(jsonPath("$.senderCustomerID").value(2))
                .andExpect(jsonPath("$.amount").value(100))
                .andExpect(jsonPath("$.registrationStatus").value("Success"))
        ;
    }

    @Test
    void getAllTransactions() throws Exception {
        mockMvc.perform(post("/transactions/")
                .content(exampleTransaction)
                .accept(MEDIA_TYPE_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(jsonPath("$.recipientCustomerID").value(1))
                .andExpect(jsonPath("$.senderCustomerID").value(2))
                .andExpect(jsonPath("$.amount").value(100))
                .andExpect(jsonPath("$.registrationStatus").value("Success"))
        ;

        mockMvc.perform(post("/transactions/")
                .content(exampleTransaction2)
                .accept(MEDIA_TYPE_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(jsonPath("$.recipientCustomerID").value(2))
                .andExpect(jsonPath("$.senderCustomerID").value(3))
                .andExpect(jsonPath("$.amount").value(1000))
                .andExpect(jsonPath("$.registrationStatus").value("Success"))
        ;

        mockMvc.perform(get("/transactions/")
                .accept(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(jsonPath("$.*", hasSize(greaterThanOrEqualTo(2))));

    }
}