package com.sjy.spark.test.leetcode.sort.design.factory.abstractFactory;

/**
 * 抽象工厂，以工厂创建产品族维度来建立具体的工厂
 * @author shengjunyang created on 2021/7/29
 * @version v1.0
 */
public class AFactory implements AbatractFactory{
    @Override
    public Cpu createCpu() {
        return new ACpu();
    }

    @Override
    public Mainboard createMainboard() {
        return new AMainboard();
    }
}
