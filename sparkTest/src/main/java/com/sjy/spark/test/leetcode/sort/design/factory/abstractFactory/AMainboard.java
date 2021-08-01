package com.sjy.spark.test.leetcode.sort.design.factory.abstractFactory;

/**
 * @author shengjunyang created on 2021/7/29
 * @version v1.0
 */
public class AMainboard implements Mainboard{
    @Override
    public void installCpu() {
        System.out.println("this is A mainboard");
    }
}
