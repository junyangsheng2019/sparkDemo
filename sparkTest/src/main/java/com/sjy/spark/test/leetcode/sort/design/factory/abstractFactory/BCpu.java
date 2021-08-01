package com.sjy.spark.test.leetcode.sort.design.factory.abstractFactory;


/**
 * @author shengjunyang created on 2021/7/29
 * @version v1.0
 */
public class BCpu implements Cpu {
    @Override
    public void calculate() {
        System.out.println(" this is B cpu");
    }
}
