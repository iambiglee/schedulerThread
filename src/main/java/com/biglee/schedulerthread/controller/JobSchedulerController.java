package com.biglee.schedulerthread.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：DELL
 * @date ：Created in 2021/4/17 10:22
 * @description：
 * @version:
 */
@RestController
public class JobSchedulerController {
    protected final Log log = LogFactory.getLog(getClass());

    private static final ThreadPoolExecutor POOL_EXECUTOR;

    static {
        POOL_EXECUTOR = new ThreadPoolExecutor(10,
                100,
                10,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(100),
                r -> {
                    Thread thread=new Thread(r);
                    thread.setDaemon(true);
                    return thread;
                });
    }
    @GetMapping(value = "login.go")
    public String loggin() {
        System.out.println("Task is start");
        POOL_EXECUTOR.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            if (System.currentTimeMillis()%2==0){
                System.out.println("停止线程");
            }
            System.out.println(Thread.currentThread().getThreadGroup());
        });
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "login";
    }

    ThreadPoolTaskScheduler threadPoolTaskScheduler;
    @GetMapping(value = "logout")
    public String logout() {
        threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        log.warn(getClass().hashCode());
        log.warn("=====================================" + threadPoolTaskScheduler.hashCode());
        threadPoolTaskScheduler.setThreadNamePrefix("OrderCancel-MyTestThread-");
        threadPoolTaskScheduler.setDaemon(true);
        threadPoolTaskScheduler.initialize();
        Long startTime = System.currentTimeMillis();
        //开始执行定时线程RecordTimeRunnable
        RecordTimeRunnable timeRunnable = new RecordTimeRunnable(startTime);
        ((TaskScheduler) threadPoolTaskScheduler).scheduleWithFixedDelay(timeRunnable, 2000);
        log.warn("++++++++++++++++++++++++++++++++++++" + threadPoolTaskScheduler.hashCode());
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.warn("++++++++++++++++++++++++++++++++++++" + threadPoolTaskScheduler.hashCode());
        threadPoolTaskScheduler.destroy();
        log.warn("-------------------------------------threadPoolTaskScheduler = " + threadPoolTaskScheduler.hashCode());
        return "login";
    }

}
