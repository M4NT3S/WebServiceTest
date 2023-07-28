package com.personal.webapp.SalutiWebService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(classes = SalutiWebServiceApplication.class)
public class Testing {

    @Test
    public void testing(){
        assertEquals("true", "true");
    }
}
