package com.sjy.spark.test.leetcode.sort;


import com.sjy.spark.test.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的所有路径 257
 * @author shengjunyang created on 2021/8/7
 * @version v1.0
 */
public class BinaryTreeAllPath {

    public List<String> binaryTreePaths(TreeNode root) {
        //二叉树的的所有路径，回溯，递归
        //叶子节点就是为null,输出的数组
        List<String> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<String> pathQueue = new LinkedList<String>();
        if(root==null)
            return res;
        queue.offer(root);
//        pathQueue.offer(Integer.toString(root.val));
        while(!queue.isEmpty()){
            int size= queue.size();
            //根左右
            TreeNode curr = queue.poll();
            String path =  pathQueue.poll();
            //如果左节点为空，且右节点为空，即记录下来，否则
//            if(root.left==null&&root.right==null){
//                res.add(path);
//            }
//            //左节点不为空，右节点为空，
//            if(root.left==null&&root.right!=null){
//                queue.offer(root.right);
//                pathQueue.offer(new StringBuffer(path).append("->").append(root.right.val).toString);
//            }
//            if(root.left!=null){
//                queue.offer(root.left);
//                pathQueue.offer(new StringBuffer(path).append("->").append(root.left.val).toString);
//            }
        }
        return res;


    }
}
