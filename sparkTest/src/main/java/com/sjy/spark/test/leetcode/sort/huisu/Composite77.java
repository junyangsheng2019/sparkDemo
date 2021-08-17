package com.sjy.spark.test.leetcode.sort.huisu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shengjunyang created on 2021/8/9
 * @version v1.0
 */
public class Composite77 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
     backTrack(n,k,1);
     return result;
    }

    private void backTrack(int n, int k, int startIndex) {

        if(path.size()==k){
            result.add(new ArrayList<>(path));
            return;//返回
        }
        for(int i=startIndex;i<=n;i++){
            //处理节点，递归，回溯
            path.add(i);
            backTrack(n,k,i+1);
            path.remove(path.size()-1);
        }
    }


//
//    public List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> list = new ArrayList<>();
//        if (n == 1 && k == 1) {
//            List<Integer> temp = new ArrayList<>();
//            temp.add(1);
//            list.add(temp);
//            return list;
//        }
//
//        //回溯算法
//        for (int i = 1; i <= n; i++) {
//            List<Integer> temp = new ArrayList<>();
//            for (int j = i; j <= n; j++) {
//                if (temp.size() <= k) {
//                    temp.add(j);
//                }
//                if (temp.size() == k) {
//                    if(k==1){
//                        list.add(new ArrayList<>(temp));
//                        list = list.stream().distinct().collect(Collectors.toList());
//                    }else {
//                        list.add(new ArrayList<>(temp));
//                    }
//                    temp.remove(temp.indexOf(j));
////                    temp.remove(temp.size()-1);
//
//                }
//            }
//            //去掉第j个数字
//        }
//        return list;
//    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        Composite77 composite77 = new Composite77();
        List<List<Integer>> temp = composite77.combine(3, 2);
        temp.stream().forEach(s -> System.out.println(s.toString()));
    }
}
