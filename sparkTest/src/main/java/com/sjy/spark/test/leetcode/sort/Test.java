package com.sjy.spark.test.leetcode.sort;

import com.sjy.spark.test.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shengjunyang created on 2021/8/10
 * @version v1.0
 */
public class Test {
    public static void main(String[] args) {

    }
    //二叉树返回最左，最小的数
    public TreeNode BinaryTree(TreeNode root){
        if(root==null)
            return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
//            if(root.left==null&&root.right==null){
//                return queue.poll();
//            }
//            if(curr.left!=null){
//                queue.offer(curr.right);
//            }
//            if(curr.right!=null){
//                queue.offer(curr.left);
//            }

        }
        return  null;
    }
}
