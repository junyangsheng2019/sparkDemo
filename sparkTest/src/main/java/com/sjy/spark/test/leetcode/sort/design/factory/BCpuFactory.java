package com.sjy.spark.test.leetcode.sort.design.factory;

/**
 * 工厂方法模式中，工厂也是抽象的，一个工厂对应一个抽象产品
 * @author shengjunyang created on 2021/7/29
 * @version v1.0
 */
public class BCpuFactory implements CpuFactoryV2{
    @Override
    public Cpu createCpu() {
        return new BCpu();
    }
}
