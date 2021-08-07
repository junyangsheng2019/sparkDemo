package com.sjy.spark.test.leetcode.sort;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author shengjunyang created on 2021/8/6
 * @version v1.0
 */
public class LRU146 {
    //lru最近最少使用，删除，使用linkedHashMap，保持插入顺序
    private  int cap;
    private Map<Integer, Integer> map = new LinkedHashMap<>();

    public LRU146(int capacity) {
        this.cap = capacity;

    }
    // 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
    public int get(int key) {
        //获取数据
        if (map.keySet().contains(key)) {
            int value = map.get(key);
            map.remove(key);
            //保证每次查询后，都在末尾
            map.put(key, value);
            return value;
        }
        return -1;
    }
    //如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
    public void put(int key, int value) {
        if(map.keySet().contains(key)){
            //插入数据的时候，如果有则去掉该数据
            map.remove(key);
        }else if(map.size()==cap){
            //就是去掉第一个
            map.remove(0);
            //当map的容量等于cap时，说明容量满了，此时需要删除最开始的，再插入新的
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();//先插入的，在前面，需要删除未使用的，删除最开始的
            iterator.remove();
            //去掉该数据
        }
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRU146 obj = new LRU146(2);
//        int param = obj.get(2);
        obj.put(1,1);
        obj.put(2,2);
        obj.put(3,3);
    }

}
