package com.efruit.micro.arkmanager.controller;


import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class OrderControllerTest extends BaseControllerTest {

    @Test
    public void testGetOrderPeriodTypeMap() throws Exception {
        String url = "/manage/getOrderPeriodTypeMap";
        final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(builder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        final String contentAsString = result.getResponse().getContentAsString();
        System.out.println("Result content : " + contentAsString);

    }

    @Override
    protected Object getController() {
        return new OrderController();
    }
}
