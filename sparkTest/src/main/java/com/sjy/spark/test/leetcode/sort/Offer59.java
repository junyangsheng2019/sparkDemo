package com.sjy.spark.test.leetcode.sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Offer59 {
    /**
     * 滑动窗口的最大值
     * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     *
     * 示例:
     *
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */

    public static int[] maxSlidingWindow(int[] nums, int k) {
        //滑动窗口最大值
        int[] res = new int[nums.length-k+1];
        if (k <= 0 || nums == null) {
            return new int[]{};
        }
        int i = 0, j = 0, len = nums.length - 1;
        while (j < nums.length-k+1) {
            List<Integer> list = new ArrayList<>();
            while (j-i <k) {
                list.add(nums[j]);
                j++;
            }

            int max=0;
            for(int num :list){
                if(num>max){
                    max=num;
                }
            }
            res[i] = max;
            i++;
            j = i;

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums =new int[]{1,3,-1,-3,5,3,6,7};
        for(int i=0;i<maxSlidingWindow(nums, 3).length;i++){
            System.out.println(maxSlidingWindow(nums,3)[i]);
        }
    }
}
