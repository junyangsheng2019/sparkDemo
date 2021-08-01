package com.sjy.spark.test.leetcode.sort.design.factory.abstractFactory;


/**
 * 具体产品实现
 * @author shengjunyang created on 2021/7/29
 * @version v1.0
 */
public class ACpu implements Cpu {
    @Override
    public void calculate() {
        System.out.println("this is A cpu");
    }
}
