package com.biglee.schedulerthread.service;

import com.biglee.schedulerthread.entity.Home;
import com.biglee.schedulerthread.repo.HomeRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：DELL
 * @date ：Created in 2021/5/19 21:21
 * @description：
 * @version:
 */
@Service
public class HomeService {
    @Resource
    HomeRepo homeRepo;

    public Home findHome(String id){
        Home homeById = homeRepo.findHomeById(id);
        return homeById;
    }
}
