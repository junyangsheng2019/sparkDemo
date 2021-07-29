package com.sjy.spark.test.leetcode.sort.dp;

/**
 * 最大子序和
 */
public class Test53 {
    public int maxSubArray(int[] nums) {
        //最大子序和
        int len = nums.length;
        int[] dp = new int[len];
        if (len == 0)
            return 0;
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            //dp[i]=dp[i-1]+nums[i]  和当前nums[i]的和，如果加了还小，那就不加
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
