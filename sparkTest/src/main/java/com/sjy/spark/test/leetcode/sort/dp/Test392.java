package com.sjy.spark.test.leetcode.sort.dp;

/**
 * @author shengjunyang created on 2021/8/1
 * @version v1.0
 */
public class Test392 {
    /**
     * 判断子序列
     */
    public static boolean isSubsequence(String s, String t) {
       // 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
        int i=0,j=0,k=0;
        while (i<s.length()&&j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
                k++;
            }else {
                j++;
            }
        }
        if(k==s.length()){
            return true;
        }
        return false;
        }

    public static void main(String[] args) {
        boolean flag = isSubsequence("axc", "ahbgdc");
        System.out.println(flag);
    }
}
