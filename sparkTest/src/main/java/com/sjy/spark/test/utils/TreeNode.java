package com.sjy.spark.test.utils;


/**
 * @author shengjunyang created on 2021/8/7
 * @version v1.0
 */
public class TreeNode {
    int val;
    private TreeNode left;
    private TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
