package com.sjy.spark.test.Jvm;

/**
 * @author shengjunyang created on 2021/8/6
 * @version v1.0
 */
public class SecondThread implements Runnable{
    private int i;
    @Override
    public void run() {
        for (;i<20;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i==20)
            {
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i==5)
            {
                SecondThread s1=new SecondThread();
                Thread t1=new Thread(s1,"线程1");
                Thread t2=new Thread(s1,"线程2");
                t1.start();
                t2.start();

            }
        }
    }
}
