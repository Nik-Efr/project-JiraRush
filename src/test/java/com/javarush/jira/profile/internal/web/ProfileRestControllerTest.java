package com.javarush.jira.profile.internal.web;

import com.javarush.jira.AbstractControllerTest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.jira.login.internal.UserMapper;
import com.javarush.jira.login.internal.UserRepository;
import com.javarush.jira.profile.ContactTo;
import com.javarush.jira.profile.ProfileTo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Set;

import static com.javarush.jira.login.internal.web.UserTestData.ADMIN_MAIL;
import static com.javarush.jira.login.internal.web.UserTestData.MANAGER_MAIL;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class ProfileRestControllerTest extends AbstractControllerTest {
    private static final String REST_URL = ProfileRestController.REST_URL;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void get_unauthenticated_returnsUnauthorized() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithUserDetails(ADMIN_MAIL)
    void update_invalidContact_returnsValidationErrors() throws Exception {
        ProfileTo invalidTo = new ProfileTo(
                2L,
                Set.of("assigned"),
                Set.of(new ContactTo("", "invalid_contact"))
        );

        perform(MockMvcRequestBuilders.put(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidTo)))
                .andExpect(status().isUnprocessableEntity());
    }


    @Test
    @WithUserDetails(ADMIN_MAIL)
    void get_authenticatedUser_returnsProfile() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.mailNotifications").isArray())
                .andExpect(jsonPath("$.contacts").isArray());
    }


    @Test
    @WithUserDetails(ADMIN_MAIL)
    void update_validData_success() throws Exception {
        ProfileTo updateTo = new ProfileTo(
                2L,
                Set.of("assigned"),
                Set.of(new ContactTo("skype", "adminSkype"))
        );

        perform(MockMvcRequestBuilders.put(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateTo)))
                .andExpect(status().isNoContent());
    }


}
