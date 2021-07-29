package com.sjy.spark.test.leetcode.sort.dp;

public class Test213 {
    public static void main(String[] args) {
        int[] nums = new int[]{200,3,140,20,10};
        int max = rob(nums);
        System.out.println(max);
    }
    public  static  int rob(int[] nums) {
        //判断最后一个房屋和第一个房屋的金额
        //不间隔的偷,dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        //第一种，去掉第一个
        //第二种，去掉最后一个
        //取最大值
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int len = nums.length;
        int k=0;
        int[] num1 = new int[len-1];
        int[] num2 = new int[len-1];
        for(int i=1;i<len;i++){
            num1[k]=nums[i];
            k++;
        }
        k=0;
        for(int i=0;i<len-1;i++){
            num2[k]=nums[i];
            k++;
        }

        return Math.max(rob2(num1),rob2(num2));
    }
    public static int rob2(int[] nums){
        if(nums.length==0)
            return 0;
        int[] dp = new int[nums.length];
        int max=0;
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            //dp[i]的最大是，前面dp[i-1]的最大，或者dp[i-2]+最后一个值
            //不能偷窃,要么第一个偷，要么最后一个偷。不抢第一个的时候，最后一个可抢可不抢
            if(i==nums.length-1)
                dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
            max=dp[i];
        }
        return max;
    }
}
