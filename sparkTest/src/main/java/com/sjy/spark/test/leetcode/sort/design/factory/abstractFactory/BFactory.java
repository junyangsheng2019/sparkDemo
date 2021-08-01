package com.sjy.spark.test.leetcode.sort.design.factory.abstractFactory;

/**
 * @author shengjunyang created on 2021/7/29
 * @version v1.0
 */
public class BFactory implements AbatractFactory{
    @Override
    public Cpu createCpu() {
        return new BCpu();
    }

    @Override
    public Mainboard createMainboard() {
        return new BMainboaard();
    }
}
