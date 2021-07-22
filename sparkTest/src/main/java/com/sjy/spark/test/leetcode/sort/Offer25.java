package com.sjy.spark.test.leetcode.sort;

public class Offer25 {

     //* Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
    /**
     * 合并两个排序的链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //合并排序的链表
        if(l1==null||l2==null){
            return l1==null?l2:l1;
        }

        if(l1.val<=l2.val){
            l1.next=  mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
