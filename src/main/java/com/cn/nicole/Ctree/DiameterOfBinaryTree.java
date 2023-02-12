package com.cn.nicole.Ctree;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 11/1/22 9:30 PM
 * desc  :

        给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

        示例 :
        给定二叉树

                  1
                 / \
                2   3
               / \
              4   5
        返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/diameter-of-binary-tree

        每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和。
        所以解体思路：1.当前节点的最长直径=左子树的深度+右子树的深度。所以存在两个变量：直径和深度。直径比较选出Max，则定义为全局变量，深度则递归返回。
 */

import com.cn.nicole.entity.TreeNode;

public class DiameterOfBinaryTree {

    static int maxDiameter = 0;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1);
        node3.left = node1;
        node3.right = node2;
        node5.left = node3;
        node5.right = node4;
        System.out.println(diameterOfBinaryTree(node5));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        /**
         * 方法一：有两层递归，一层计算节点的深度，一层计算节点的最大直径。两种递归都可以整理到后序中实现
         * ，所以可以将最大直径和深度递归整理到一个方法中。
         */
      //  traverse(root);
        int depth = maxDepth2(root);
        return maxDiameter;
    }

    private static int maxDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left, right) + 1;
    }

    /**
     * 方法一
     * 节点的最大直径
     * @param root
     */
    private static void traverse(TreeNode root) {
        if(root == null){
            return ;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        traverse(root.left);
        traverse(root.right);

    }

    /**
     * 节点的最大深度
     * @param root
     * @return
     */
    private static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right)+1;
    }

}
