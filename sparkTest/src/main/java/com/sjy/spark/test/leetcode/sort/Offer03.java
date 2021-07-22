package com.sjy.spark.test.leetcode.sort;


public class Offer03 {
    /**
     * 数组中重复的数字
     * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
    /*  HashMap<Integer,Integer> map = new HashMap<>();
        for(int num :nums){
            if(map.containsKey(num)){
                return num;
            }
            map.put(num,1);
        }
        return 0;*/

        //利用索引与数字的关系，时间o(n)，空间o(1)，修改了原数据
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                //返回该值
                return nums[i];
            } else {
                //交换
                int tmp = nums[nums[i]];
                nums[i] = tmp;//nums[0]=tmp
                nums[nums[i]] = i;
            }
        }
        return 0;
    }

    //原地交换
    public int findRepeatNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}
