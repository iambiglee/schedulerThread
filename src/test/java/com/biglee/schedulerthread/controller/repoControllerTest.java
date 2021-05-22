package com.biglee.schedulerthread.controller;

import com.biglee.schedulerthread.entity.Home;
import com.biglee.schedulerthread.service.HomeService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.mockito.Mockito.doReturn;

/**
 * @author BigLee E-mail:biglee001@hotmail.com
 * @date 2021/4/23 15:17
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class repoControllerTest {

    @Resource
    private MockMvc mockMvc;
    @SpyBean
    HomeService homeService;
    @BeforeEach
    void setUp(){
        Home home = new Home();
        home.setId("2");
        doReturn(home).when(homeService).findHome("1");
    }

    @Test
    @DisplayName("返回值校验")
    void login() throws Exception {

        Home home1 = homeService.findHome("1");
        Assertions.assertEquals("2",home1.getId());

        mockMvc.perform(MockMvcRequestBuilders.get("/save") //执行请求
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json("login"))
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    @DisplayName("返回值校验")
    void mockBefore() {
        Home home1 = homeService.findHome("1");
        Assertions.assertEquals("2",home1.getId());
    }
}