package com.various.restservice.controllers;

import com.various.restservice.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder.*;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import javax.servlet.ServletContext;

/**
 * Created by Acer on 02.09.2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddFuelDataControllerTest {
    @Autowired
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
//
//                    new RequestBuilder() {
//                @Override
//                public MockHttpServletRequest buildRequest(ServletContext servletContext) {
//                    MockHttpServletRequest request = new MockHttpServletRequest();
//                    request.setMethod("POST");
//                    request.setServerName("127.0.0.1");
//                    request.setRequestURI(Constants.ADDFUELDATA);
//                    request.setQueryString("fueltype=D&price=1.27&volume=23.8&date=01.08.2018&driverid=12345");
//                    request.setServerPort(8080);
//                    return request;
//                }
//            }).andExpect(status().isOk());
//        Assert.assertEquals(200, response.getStatus());
    }
}
