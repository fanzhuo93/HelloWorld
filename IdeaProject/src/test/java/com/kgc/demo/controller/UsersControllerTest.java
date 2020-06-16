package com.kgc.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void toRegUser()throws Exception {
        MockHttpServletRequestBuilder requestBuilder= MockMvcRequestBuilders.post("/user/toRegUser");
    }
}