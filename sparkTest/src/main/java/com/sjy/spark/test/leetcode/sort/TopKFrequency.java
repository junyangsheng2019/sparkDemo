package com.sjy.spark.test.leetcode.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author shengjunyang created on 2021/8/5
 * @version v1.0
 */
public class TopKFrequency {
    /**
     * 前k个高频元素，小根堆
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        //key是key,value是出现次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //根据map的value值正序排，相当于一个小顶堆
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry entry: entries){
            queue.offer(entry);
            if(queue.size()>k){
                queue.poll();//保留k个元素，使用小顶堆，若个数大于k,每次弹出最小的元素
            }
        }
        //把队列出队，由于是小根堆，所以最大的出在前面，数组逆序出来。
        for (int i = k-1; i >=0; i--) {
            result[i] = queue.poll().getKey();
        }
    return  result;
    }
}
