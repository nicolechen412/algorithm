package com.cn.nicole;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        System.out.println(LocalTime.now());
        LocalTime time = LocalTime.of(10,30);
        System.out.println(time);

//        Thread a  = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true){
//                    int  b = 1;
//                }
//            }
//        });
//
//        a.start();
//
//        Thread.sleep(2000);

        String s1 = "aaa";
        String s3 = s1 + "bbb";
//        String s4 = "aaabbb";
//        String s5 = "bbb";
//        System.out.println(s3 == s4);
    }
}
