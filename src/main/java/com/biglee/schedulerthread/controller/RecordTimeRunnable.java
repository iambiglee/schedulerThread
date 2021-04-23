package com.biglee.schedulerthread.controller;

public class RecordTimeRunnable implements Runnable {

    private final Long startTime;

    public RecordTimeRunnable(Long startTime) {
        this.startTime = startTime;
    }

    @Override
    public void run() {
        //获取线程运行时间
        System.out.println(System.currentTimeMillis() - startTime);
        //获取线程名称
//        System.out.println(Thread.currentThread().getName());
        int i = 1;
        i += 1;
    }

}
