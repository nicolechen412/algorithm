package com.cn.nicole.Ctree;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2022/3/6 4:29 下午
 * desc  :
 */

import com.cn.nicole.entity.TreeNode;
import com.cn.nicole.util.TreeUtil;

import java.util.Stack;

/**
 * 调查搜索二叉树中两个错误节点
 *
 *      错误存在两种情况：
 *          1.遍历时出现两种降序：{1,5,3,4,2}； 2.出现一种降序{1,2,4,3,5}。总结为第一个错误节点为第一个降序时较大的节点和第二个错误节点为最后一次降序是最小的节点。
 *
 *      解决方法：
 *          改写一个基本的中序遍历，比较当前节点与前一个节点的value值，则第一次出现错误的第一个节点和最后一次出现错误的后一个节点为两个错误节点。
 */
public class GetTwoErrNodes {
    public static void main(String[] args) {

        //存在两种降序的情况
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(5);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(2);
//
//        node2.left = node1;
//        node2.right = node3;
//        node4.left = node2;
//        node4.right = node5;

        //存在一种降序的情况
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);

        node2.left = node1;
        node2.right = node3;
        node4.left = node2;
        node4.right = node5;


        TreeUtil.pringTreeByPre(node4);
        TreeNode[] errNode = new TreeNode[2];

        TreeNode[] ints = new TreeNode[]{
                new TreeNode(Integer.MIN_VALUE),
                new TreeNode(Integer.MAX_VALUE)
        };
        //使用递归中序遍历
//        getTwoErrNodes(node4,errNode, ints);
        //使用非递归中序遍历
       errNode =  getTwoErrNodes(node4);
        System.out.println(errNode[0].val + " " + errNode[1].val);
    }

    public static void getTwoErrNodes(TreeNode head, TreeNode[] err, TreeNode[] maxAmin){

        if(head == null){
            return ;
        }

        getTwoErrNodes(head.left,  err, maxAmin);

        if(maxAmin[0].val > head.val){
            err[0] = err[0] == null ? maxAmin[0] : err[0];
            err[1] = head;
        }
        maxAmin[0] = (maxAmin[0].val >  head.val) ? maxAmin[0] : head;
        maxAmin[1] = (maxAmin[1].val < head.val) ? maxAmin[1] : head;

        getTwoErrNodes(head.right, err, maxAmin);

    }

    public static TreeNode[] getTwoErrNodes(TreeNode head){

        if(head == null){
            return null;
        }
        TreeNode pre = null;
        TreeNode[] errs = new TreeNode[2];
        Stack<TreeNode> stack = new Stack<>();
        while(head != null || !stack.isEmpty()){
            if(head != null){
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if(pre != null && pre.val > head.val){
                    errs[0] = errs[0] == null ? pre : errs[0] ;
                    errs[1] = head;
                }
                pre = head;
                head = head.right;

            }
        }
        return errs;
    }
}
