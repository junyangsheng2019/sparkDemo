package com.sjy.spark.test.leetcode.sort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 完全二叉树的节点个数
 * @author shengjunyang created on 2021/8/5
 * @version v1.0
 */
public class Tree222 {

      //Definition for a binary tree node.
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
    public int countNodes(TreeNode root) {
        //完全二叉树的节点个数
        if(root==null)
            return 0;
        int num=0;
        //层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            //当前节点
            TreeNode curr =  queue.poll();
            num++;
            //根左右
            if(curr.left!=null) {
                queue.offer(root.left);
            }
            if(curr.right!=null){
                queue.offer(root.right);
            }
        }
    return num;
    }
}
