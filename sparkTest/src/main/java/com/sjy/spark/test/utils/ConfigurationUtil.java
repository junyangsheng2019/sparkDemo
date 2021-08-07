package com.sjy.spark.test.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池demo
 * @author shengjunyang created on 2021/8/7
 * @version v1.0
 */
public class ConfigurationUtil {
    public static void main(String[] args) {
        ConfigurationUtil configurationUtil= new ConfigurationUtil();
        configurationUtil.doProcess();
    }
    private void doProcess(){
        ExecutorService exec = null;

        try{
            exec = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                    Runtime.getRuntime().availableProcessors()*2,30,
                    TimeUnit.SECONDS,new LinkedBlockingDeque<>());
            for(int i=0;i<10;i++){
                //new一个线程使用
                TestPoolThreadRunnable thread = new TestPoolThreadRunnable(i);
                exec.execute(thread);
            }

            exec.shutdown();
            //加上这段代码的主要作用就是所有线程执行完成才会跳出当前方法，如果不加的话当还在执行线程的时候，就会执行其他方法。
            try {
                while (exec.awaitTermination(10,TimeUnit.SECONDS));
            }catch (Exception e){
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("thread finished ");
    }
    class TestPoolThreadRunnable implements Runnable{
        private Integer count;

        public TestPoolThreadRunnable(Integer count){
            this.count = count;
        }
        /**
         * <p>Title: run</p>
         * <p>Description: </p>
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run() {
            System.out.println(count++);

        }

    }
}
