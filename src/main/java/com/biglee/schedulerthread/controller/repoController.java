package com.biglee.schedulerthread.controller;

import com.biglee.schedulerthread.entity.Home;
import com.biglee.schedulerthread.repo.HomeRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

/**
 * @author ：DELL
 * @date ：Created in 2021/4/23 13:19
 * @description：
 * @version:
 */
@RestController
public class repoController {
    @Resource
    HomeRepo homeRepo;
    @GetMapping(value = "save")
    public Home save() {
        Home home=new Home();
        home.setCity("wu han");
        home.setName("han zhong");
        Timestamp timestamp = new Timestamp(new Date().getTime());
        home.setUpdateTime(timestamp);
        home.setId(String.valueOf(UUID.randomUUID()));
        homeRepo.saveAndFlush(home);
        return home;
    }
}
