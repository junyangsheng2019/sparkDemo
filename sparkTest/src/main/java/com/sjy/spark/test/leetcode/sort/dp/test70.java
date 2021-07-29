package com.sjy.spark.test.leetcode.sort.dp;

public class test70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
    public static int climbStairs(int n) {
        //(n-1)阶，最后一步只需要一步
        if(n<=0)
            return 0;
        int[] dp = new int[n];
        dp[1]=1;
        dp[2]=2;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+1;
        }
        return dp[n];
    }
}
