package com.sjy.spark.test.leetcode.sort.design.factory;

/**
 * @author shengjunyang created on 2021/7/29
 * @version v1.0
 */
public class FactoryMethodTest {
    /**
     * 工厂方法模式测试类
     * @param args
     */
    public static void main(String[] args) {

        Cpu cpua = new ACPuFactory().createCpu();
        cpua.calculate();
        Cpu cpub = new BCpuFactory().createCpu();
        cpub.calculate();
        //a
        CpuFactoryV2 afactory = new ACPuFactory();
        Cpu cpu = afactory.createCpu();
        cpu.calculate();
    }
    //简单工厂&工厂方法模式的区别
    //简单工厂模式中工厂类没有抽象层，而工厂方法模式中，工厂类有抽象层
    //工厂方法模式和抽象工厂模式最大的区别
//    工厂方法模式针对是一个产品等级结构，而抽象工厂模式针对的是多个产品登记结构


}
