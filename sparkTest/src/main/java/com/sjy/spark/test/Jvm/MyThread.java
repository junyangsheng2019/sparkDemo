package com.sjy.spark.test.Jvm;

/**
 * @author shengjunyang created on 2021/8/6
 * @version v1.0
 */
public class MyThread extends Thread{
    private int i;

    @Override
    public void run() {
        for (;i<10;i++){
            System.out.println(getName()+"\t"+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"\t"+i+"======");
            if(i==5){
                MyThread my1 = new MyThread();
                MyThread my2 = new MyThread();
                my1.start();
                my2.start();
            }
        }
    }
}
