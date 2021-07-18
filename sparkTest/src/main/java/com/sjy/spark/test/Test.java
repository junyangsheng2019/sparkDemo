package com.sjy.spark.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
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
    public static void main(String[] args) {
        String s ="sasasa";
        System.out.println(s.substring(0,2));
        System.out.println(s.toString());
    }
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root==null)
            return res;
        dfs(root,target);
        return res;
    }
    public void dfs(TreeNode root,int target) {
        if (root == null)
            return;
        //把节点加到路径上
        path.add(root.val);
        //减枝，
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            res.add(new ArrayList(path));
            res.remove(root.val);
        }
        if (root.left != null) {
            dfs(root.left, target);
        }
        if (root.right != null) {
            dfs(root.right, target);
        }
    }
}
