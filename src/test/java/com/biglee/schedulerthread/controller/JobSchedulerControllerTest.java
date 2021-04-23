package com.biglee.schedulerthread.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

/**
 * @author BigLee E-mail:biglee001@hotmail.com
 * @date 2021/4/23 8:35
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class JobSchedulerControllerTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    @DisplayName("开始网络测试")
    void login() throws Exception {
        String jwtToken="abcdefg";
        mockMvc.perform(MockMvcRequestBuilders.get("/login.go") //执行请求
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .param("name", "Tom"))
			.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("login"));
//                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    void logout() {
    }
}