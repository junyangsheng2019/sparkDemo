package com.sjy.spark.test.leetcode.sort.design.factory.abstractFactory;

/**
 * @author shengjunyang created on 2021/7/29
 * @version v1.0
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        //注入A工厂
        AbatractFactory factory = new AFactory();
        Cpu cpu = factory.createCpu();
        Mainboard mainboard = factory.createMainboard();
        cpu.calculate();
        mainboard.installCpu();
    }
}
