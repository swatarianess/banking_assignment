package com.steve.banking_assignment;

import com.steve.banking_assignment.controllers.AccountRegistrationController;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class AccountRegistrationControllerTest {

    MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", StandardCharsets.UTF_8);
    String exampleUserOne = "{\"customerID\": 111,  \"name\": \"steve\", \"surname\": \"adu\"}";
    String exampleUserTwo = "{\"customerID\": 222,  \"name\": \"bob\", \"surname\": \"bob\", \"balance\": 1000}} ";

    @Autowired
    protected MockMvc mockMvc;

   @Autowired
   AccountRegistrationController controller;

    @BeforeEach
    void setUp(WebApplicationContext webApplicationContext) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @Tag("account")
    @Tag("development")
    @DisplayName("Creation of account with default initial credit")
    void accountTestDefaultCredit() throws Exception {
        mockMvc.perform(post("/accounts/")
                .content(exampleUserOne)
                .accept(MEDIA_TYPE_JSON_UTF8)
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(jsonPath("$.name").value("steve"))
                .andExpect(jsonPath("$.customerID").value(111))
                .andExpect(jsonPath("$.registrationStatus").value("Success"))
        ;

        mockMvc.perform(get("/accounts/111"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("steve"))
                .andExpect(jsonPath("$.balance").value(0))
        ;

    }

    @Test
    @Tag("account")
    @Tag("development")
    @DisplayName("Creation of account with custom initial credit")
    void accountTestCustomInitialCredit() throws Exception {
        mockMvc.perform(post("/accounts/")
                .content(exampleUserTwo)
                .accept(MEDIA_TYPE_JSON_UTF8)
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(jsonPath("$.name").value("bob"))
                .andExpect(jsonPath("$.customerID").value(222))
                .andExpect(jsonPath("$.registrationStatus").value("Success"))
        ;

        mockMvc.perform(get("/accounts/222"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("bob"))
                .andExpect(jsonPath("$.balance").value(1000))
        ;
    }
}