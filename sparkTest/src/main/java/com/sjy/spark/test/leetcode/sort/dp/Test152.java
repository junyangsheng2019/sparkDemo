package com.sjy.spark.test.leetcode.sort.dp;

public class Test152 {
    public static void main(String[] args) {
        int n = maxProduct(new int[]{2,3,-2,4});
        System.out.println(n);
    }
    public static int maxProduct(int[] nums) {
        //连续子数组的乘积最大
        if(nums==null)
            return 0;
        int[] dp = new int[nums.length];
        int len = nums.length;
        dp[0]=nums[0];
        int max=dp[0];
        for(int i=1;i<len;i++){
            dp[i] = Math.max(dp[i-1]*nums[i],nums[i]);
            max =Math.max(dp[i],max);
        }
//        maxDP[i] = Math.max(nums[i], Math.max(maxDP[i-1]*nums[i], minDP[i-1]*nums[i]));
//        minDP[i] = Math.min(nums[i], Math.min(maxDP[i-1]*nums[i], minDP[i-1]*nums[i]));
//        //记录ans；
//        ans = Math.max(ans, maxDP[i]);
        return max;
    }
}
