package com.sjy.spark.test;

import org.apache.commons.collections.CollectionUtils;
import org.apache.hadoop.util.hash.Hash;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;
import scala.Char;

import java.util.*;

public class SparkTestChap1 {
    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("JavaSparkPi")
                .getOrCreate();

        JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());

        int slices = (args.length == 1) ? Integer.parseInt(args[0]) : 2;
        int n = 100000 * slices;
        List<Integer> l = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            l.add(i);
        }

        JavaRDD<Integer> dataSet = jsc.parallelize(l, slices);

        int count = dataSet.map(integer -> {
            double x = Math.random() * 2 - 1;
            double y = Math.random() * 2 - 1;
            return (x * x + y * y <= 1) ? 1 : 0;
        }).reduce((integer, integer2) -> integer + integer2);

        System.out.println("Pi is roughly " + 4.0 * count / n);

        spark.stop();


    }
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num :nums){
            if(map.containsKey(num)){
                return num;
            }
            map.put(num,1);
        }
        return -1;
    }
    public int lengthOfLongestSubstring(String s) {
        //最长子串,滑动窗口，两个指针，一个数组存储不重复数据

        //abcabcbb
        //存放值和其所在顺序
        HashMap<Character ,Integer> map = new HashMap<>();
        int i=0;//左标记，
        int res=0;//最大值
        for (int k=0;k< s.toCharArray().length;k++){
            if(map.containsKey(s.charAt(k))){
//                i++;//左移，更新左指针 保证i+1,j内无重复字符，且最大
                i=Math.max(i,map.get(s.charAt(k)));
            }
            map.put(s.charAt(k),k);
            //开始断了
            //删除map里的
            res = Math.max(res,k-i-1);
        }
        return res;
    }
//      Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void appendTail(int value) {
        stack1.push(value);
        Stack<Integer> stack = new Stack<>();
    }
    public int[] reversePrint(ListNode head) {
        //从尾到头打印单链表
        Stack<Integer> stack = new Stack<>();
        while(head!=null){
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i=0;i<res.length;i++){
            res[i] = stack.pop();
        }
        return res;
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    //出队列，来的元素先存入第一个栈，第一个栈满了，再往第二个栈存。删除的时候，从第二个栈出
    public int deleteHead() {
        //两个栈，实现队列，先插入第一 个栈，再插入第二个栈.
        //删除元素，如果第一个栈不为空，则把第一个栈里的元素移到第二个栈里，再把第二个栈出栈
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
            while (!stack2.isEmpty()){
                //stack2
                return  stack2.pop();
            }
        }
        return 0;
    }
    public int lengthOfLongestSubstring2(String s) {
        if(s==null)
            return 0;
        int count=0;
        int len = s.length();
        List<Character> list = new ArrayList<>();
        for(int i=0;i<len;i++){
            //找出以i位置字符开头的最长的不重复子串
            for(int j=i;j<len;j++) {
                if (list.contains(s.charAt(j))) {
                    continue;
                }
                list.add(s.charAt(j));//不重复就一直添加
                count = Math.max(count, list.size());
                if (count > len - 1 - i) {
                    //当count 大于剩下字符串的长度时不简历
                    break;
                }
                //清空记录
                list.clear();
            }
        }
        return  count;


    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //从底向上
        List<List<Integer>> list = new ArrayList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        //根左右
        if(root==null)
            return null;
        deque.offer(root);
        while (!deque.isEmpty()){
            //当队列不为空
            List<Integer> tmp = new ArrayList<>();
            int q = deque.size();
            while (q>0){
                TreeNode node = deque.pop();
                tmp.add(node.val);
                if(node.left!=null)
                    deque.push(node.left);
                if(node.right!=null)
                    deque.push(node.right);
                q--;
            }

            list.add(tmp);
        }
        Collections.reverse(list);
        return  list;
    }
}
