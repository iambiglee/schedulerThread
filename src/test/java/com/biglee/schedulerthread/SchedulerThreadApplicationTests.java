package com.biglee.schedulerthread;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

class SchedulerThreadApplicationTests {

    @Test
    void contextLoads() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        for(int i = 0; i < latch.getCount(); i++){
            new Thread(new MyThread(latch), "player"+i).start();
        }
        latch.await();
    }

    private class MyThread implements Runnable {
        private CountDownLatch latch;
        public MyThread(CountDownLatch latch) {
            this.latch=latch;
        }
        @Override
        public void run() {
            latch.countDown();
        }
    }


}
