package com.sjy.spark.test.leetcode.sort.design.factory;

/**
 * 简单工厂类
 * @author shengjunyang created on 2021/7/29
 * @version v1.0
 */
public class CpuFactory {

    /**
     * 返回值是产品的抽象类型
     * 简单工厂模式：创建哪种产品类型代码在工厂内部，如果要新增具体产品，需要修改工厂类方法，不符合开闭原则
     * 对扩展开发，对修改封闭
     * @param classType
     * @return
     */
    public static Cpu createCpu(Class classType) {
        if (classType.getName().equals(Acpu.class.getName())) {
            return new Acpu();
        } else if (classType.getName().equals(BCpu.class.getName())) {
            return new BCpu();
        }
        return null;
    }

    /**
     * 测试类
     * @param args
     */
    public static void main(String[] args) {
        Cpu cpu = CpuFactory.createCpu(BCpu.class);
        cpu.calculate();
    }
}
