package com.various.restservice.controllers;

import com.various.restservice.Application;
import com.various.restservice.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Acer on 02.09.2018.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AddFuelDataControllerTest {

    @MockBean
    private AddFuelDataController addFuelDataController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        this.request = new MockHttpServletRequest();
        request.setContentType("application/json");
        this.response = new MockHttpServletResponse();
    }


    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Test
    public void existenceDataControllerTest() throws Exception {
            mockMvc.perform(post(Constants.ADDFUELDATA))
                    .andExpect(status().isOk());
    }
}
