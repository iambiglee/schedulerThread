package com.biglee.schedulerthread.repo;

import com.biglee.schedulerthread.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：DELL
 * @date ：Created in 2021/4/23 13:21
 * @description：
 * @version:
 */
@Repository
public interface HomeRepo extends JpaRepository<Home,String> {

    Home findHomeById(String id);

    List<Home> findHomesByName(String name);

    List<Home> findHomesByCity(String city);


}
