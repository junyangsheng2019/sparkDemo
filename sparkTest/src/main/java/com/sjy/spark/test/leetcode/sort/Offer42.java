package com.sjy.spark.test.leetcode.sort;

/**
 * 连续子数组的最大和，动态规划
 */
public class Offer42 {
    public int maxSubArray(int[] nums) {
        //动态规划，前面的和大于0，继续加，不大于0，不加
        int len = nums.length;
        if(len==0)
            return 0;
        int[] dp = new int[len+1];
        dp[0]=nums[0];
        int  max=dp[0];
        for(int i=1;i<len;i++){
            //在看是否要加上当前的值
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
