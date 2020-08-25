package com.steve.banking_assignment;

import com.steve.banking_assignment.controllers.AccountRegistrationController;
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
    void accountTestDefaultCredit() throws Exception {
        mockMvc.perform(post("/account/register")
                .content(exampleUserOne)
                .accept(MEDIA_TYPE_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(jsonPath("$.name").value("steve"))
                .andExpect(jsonPath("$.customerID").value(111))
                .andExpect(jsonPath("$.registrationStatus").value("Success"))
        ;

        mockMvc.perform(get("/account/111"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("steve"))
                .andExpect(jsonPath("$.balance").value(0))
        ;

    }

    @Test
    void accountTestCustomInitialCredit() throws Exception {
        mockMvc.perform(post("/account/register")
                .content(exampleUserTwo)
                .accept(MEDIA_TYPE_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(jsonPath("$.name").value("bob"))
                .andExpect(jsonPath("$.registrationStatus").value("Success"))
        ;

        mockMvc.perform(get("/account/222"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("bob"))
                .andExpect(jsonPath("$.balance").value(1000))
        ;
    }
}