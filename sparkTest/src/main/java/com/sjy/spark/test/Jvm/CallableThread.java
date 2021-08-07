package com.sjy.spark.test.Jvm;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author shengjunyang created on 2021/8/6
 * @version v1.0
 */
public class CallableThread implements Callable<Integer> {

    int i=0;
    @Override
    public Integer call() throws Exception {
        for (;i<20;i++){
            System.out.println(Thread.currentThread().getName()+""+i);
        }
        return i;
    }

    public static void main(String[] args) {
        CallableThread tar1 = new CallableThread();
        FutureTask<Integer> ft = new FutureTask<Integer>(tar1);
        Thread t2 = new Thread(ft,"新线程");
        t2.start();
        try {
            System.out.println(ft.get());
        }catch (Exception e){
            System.out.println("error....");
        }
    }
}
