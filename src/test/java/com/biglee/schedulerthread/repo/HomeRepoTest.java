package com.biglee.schedulerthread.repo;

import com.biglee.schedulerthread.entity.Home;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author BigLee E-mail:biglee001@hotmail.com
 * @date 2021/4/23 16:36
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HomeRepoTest {
    @Resource
    private HomeRepo homeRepo;

    private String uuid;

    private Home home;
    @BeforeAll
    public void setup(){
        homeRepo.deleteAll();
        home= new Home();
        home.setUpdateTime(new Timestamp(new Date().getTime()));
        home .setCity("shanghai");
        home.setName("yu");
        uuid = UUID.randomUUID().toString().replaceAll("-", "");
        home.setId(uuid);
    }

    @Test
    void  createHome(){
        homeRepo.save(home);
        Assertions.assertTrue(homeRepo.existsById(uuid));
    }

    @Test
    void getHomeById(){
        homeRepo.save(home);
        Home homeById = homeRepo.findHomeById(uuid);
        Assertions.assertEquals(home.getCity(),homeById.getCity());
    }

    @Test
    void getHomeByCity(){
        homeRepo.save(home);
        List<Home> homeByCity = homeRepo.findHomesByCity(home.getCity());
        for (Home homeCity: homeByCity ){
            Assertions.assertEquals(home.getCity(),homeCity.getCity());
        }
    }

    @Test
    void getHomeByName(){
        homeRepo.save(home);
        List<Home> homeByName = homeRepo.findHomesByName(home.getName());
        for (Home homeCity: homeByName ){
            Assertions.assertEquals(home.getCity(),homeCity.getCity());
        }
    }

}