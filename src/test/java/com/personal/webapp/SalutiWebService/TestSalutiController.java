package com.personal.webapp.SalutiWebService;


import com.personal.webapp.SalutiWebService.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ContextConfiguration(classes = SalutiWebServiceApplication.class)
public class TestSalutiController {
    private MockMvc mvc;

    private User mockUser = new User("franco", "giacomini");

    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    public void setup(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testGetSaluti() throws Exception{

        mvc.perform(MockMvcRequestBuilders
                    .get("/api/v1/saluti/test")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$")
                            .value("Hello there, just starting from point 0 once again :)"))
                    .andDo(print());
    }

    @Test
    public void testGetSaluti2() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/saluti/Sebastian")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$")
                        .value("Hello there, Sebastian, just starting from point 0 once again :)"))
                .andDo(print());
    }

    @Test
    public void verifyPresenceOfTheCorrectUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/saluti/franco/giacomini")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$").value(mockUser)).andDo(print());
    }
}
