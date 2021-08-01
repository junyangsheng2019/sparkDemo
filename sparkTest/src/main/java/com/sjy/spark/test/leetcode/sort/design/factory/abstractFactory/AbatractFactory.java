package com.sjy.spark.test.leetcode.sort.design.factory.abstractFactory;

/**
 * 抽象工厂
 */
public interface AbatractFactory {
    //创建cpu产品
    Cpu createCpu();

    //创建主板产品
    Mainboard createMainboard();
}
