package com.sjy.spark.test.Jvm;

import java.util.Arrays;
import java.util.List;

/**
 * @author shengjunyang created on 2021/8/1
 * @version v1.0
 */
public class GenericTypes {

    public static String method(List<String> list){
        System.out.println("invoke method list<String>");
        return "";
    }
//    public static int method(List<Integer> list){
//        System.out.println("invoke method list<Integer>");
//        return 1;
//    }
    //因为泛型擦除后，都是List<E>，重载有问题，除非返回值不一样。

    public static void main(String[] args) {
//        List<Integer> list = [1,2,3,4];
        List<Integer> list = Arrays.asList(1,2,3,4);
        int sum=0;
        for (int i :list) {
            sum+=i;
        }
        System.out.println(sum);
    }
}
