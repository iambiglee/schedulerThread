package com.biglee.schedulerthread.controller;

import com.biglee.schedulerthread.entity.Home;
import com.biglee.schedulerthread.repo.HomeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author BigLee E-mail:biglee001@hotmail.com
 * @date 2021/4/23 15:17
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class repoControllerTest {

    @Resource
    private MockMvc mockMvc;
    @Resource
    HomeRepo repo;

    @Test
    @DisplayName("返回值校验")
    void login() throws Exception {
        HomeRepo spy= Mockito.spy(repo);
        Home home = new Home();
        home.setId("2");
        Mockito.when(spy.findById("1")).thenReturn(java.util.Optional.of(home));
        Optional<Home> optional = spy.findById("1");
        Assertions.assertEquals("2",optional.get().getId());

        mockMvc.perform(MockMvcRequestBuilders.get("/save") //执行请求
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json("login"))
                .andDo(MockMvcResultHandlers.print());
    }

}