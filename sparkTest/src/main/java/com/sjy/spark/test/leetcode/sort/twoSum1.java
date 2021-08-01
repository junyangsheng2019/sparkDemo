package com.sjy.spark.test.leetcode.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shengjunyang created on 2021/8/1
 * @version v1.0
 */
public class twoSum1 {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        //双指针,前提是数组有序
        int i=0,j=nums.length-1;
        while (i<=j){
            int sum = nums[i]+nums[j];
            if((target-sum)==0){
                return new int[]{nums[i],nums[j]};
            }else if(target-sum<0){
                j--;
            }else {
                i++;
            }

        }
       return new int[]{-1,-1};
    }

    /**
     * 数组无序，使用hashMap，
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map map = new HashMap<Integer,Integer>();//integer ,integer
        //key是值，value是索引
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i=0;i<nums.length;i++){
            int sum = target-nums[i];
            //如果当前值存在，且map里的值不等于该值
            if(map.containsKey(sum)&&(int)map.get(sum)!=i){
                return new int[]{(int) map.get(sum),i};
            }
        }
        return new int[]{-1,-1};
    }

}
