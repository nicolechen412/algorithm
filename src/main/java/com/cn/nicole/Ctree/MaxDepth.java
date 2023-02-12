package com.cn.nicole.Ctree;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 10/31/22 10:40 PM
 * desc  :
    给定一个二叉树，找出其最大深度。
    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    说明:叶子节点是指没有子节点的节点。

    示例：
    给定二叉树 [3,9,20,null,null,15,7]，

        3
       / \
      9  20
        /  \
       15   7
    返回它的最大深度3 。

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/maximum-depth-of-binary-tree

 */

import com.cn.nicole.entity.TreeNode;

public class MaxDepth {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7,null,null);
        TreeNode node2 = new TreeNode(15, null, null);
        TreeNode node3 = new TreeNode(20, node2, node1);
        TreeNode node4 = new TreeNode(9, null, null);
        TreeNode node5 = new TreeNode(3, node4, node3);
        System.out.println(maxDepth(node5));
    }

    public static int maxDepth(TreeNode root) {

       int maxDepth = traverse(root);
       return maxDepth;
    }

    private static int traverse(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        return  left > right ? left+1 : right +1;
    }

}
