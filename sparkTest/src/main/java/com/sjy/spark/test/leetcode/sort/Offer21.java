package com.sjy.spark.test.leetcode.sort;

public class Offer21 {

    /**
     * 奇数位于偶数的前面
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        //所有的奇数位于偶数的前面
        if(nums.length==0)
            return new int[]{};
        int left=0,right=nums.length-1;
        while(left<right){
            while(nums[left]%2!=0&&left<right){
                left++;
            }
            while(nums[right]%2==0&&left<right){
                right--;
            }
            //奇数的时候，交换，否则right--
            int temp =nums[left];
            nums[left]=nums[right];
            nums[right] = temp;
        }
        return nums;
    }

    private void swap(int num, int num1) {
        int temp = num;
        num=num1;
        num1=temp;
    }
}
