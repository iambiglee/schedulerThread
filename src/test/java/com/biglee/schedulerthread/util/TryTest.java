package com.biglee.schedulerthread.util;

import org.junit.jupiter.api.Test;

/**
 * @author ：DELL
 * @date ：Created in 2021/5/14 8:17
 * @description： try find the efficiency of the try- catch
 * @version:
 */
public class TryTest {
    @Test
    void test(){
        int k=100000000;
        int j=100000000;
        Long a=0L;
        long startTime=System.nanoTime();
        for (int i = 0; i <k ; i++) {
            a+=i;
        }
        System.out.println(System.nanoTime()-startTime);

        a=0L;
        startTime=System.nanoTime();
        for (int i = 0; i <j ; i++) {
            try {
                a+=i;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(System.nanoTime()-startTime);
    }
}

