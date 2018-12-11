package com.efruit.micro.arkmanager.controller;

import com.efruit.micro.arkmanager.BaseTest;
import org.junit.Before;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public abstract class BaseControllerTest extends BaseTest {

    protected MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        final Object controller = getController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        onSetUp();
    }

    protected abstract Object getController();

    protected void onSetUp() {

    }
}
