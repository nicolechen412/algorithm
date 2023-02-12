package com.cn.nicole.Ctree;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2022/1/6 8:16 下午
 * desc  :
 */

import com.cn.nicole.entity.TreeNode;

import java.util.Stack;

/**
 * 使用递归和非递归的方式实现二叉树的先序中序后序遍历
 *      非递归：
 *          先序：比较简单，先将头结点入栈，然后pop出来，分别判断左右节点，然后倒序push到栈中
 *          中序：当前节点不为空则push到栈中，并将节点移到左节点，为空则pop出新节点，将节点移到右节点。
 *          后序：
 *              两个栈：将头结点放入s1，然后弹出s1，将该节点的左节点和右节点放入s1，弹出的节点放入s2，继续弹出s1节点，不断重复，最后弹出s2栈中节点                     并答应。
 *              一个栈和两个变量h（最近弹出并打印的节点）和c（栈顶节点）：初始时h为头结点，c为null
 *                  每次令c为栈顶节点，但不弹出：
 *                  1.如果c的左孩子不为null，并且h不等于c的左孩子也不等于c的右孩子，则将c的左孩子压入栈中。
 *                  2.如果条件1不符合，则判读c的右孩子不为null，并且h不等于c的右孩子，则将c的右孩子压入栈中。
 *                  3.如果两个条件都不符合，说明c的左子树和右子树都打印完毕，弹出c并打印，然后令h=c。
 *                  重复这个过程，直到栈为空。
 */
public class TraverseTree {

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

//        preOrderRecur(node1);
//        System.out.println();
//        inOrderRecur(node1);
//        System.out.println();
        postOrderRecur(node1);
        System.out.println();
//        preOrderUnRecur(node1);
//        System.out.println();
//        inOrderUnRecur(node1);
//        System.out.println();
        postOrderUnRecur(node1);
        System.out.println();
        postOrderUnRecur2(node1);
        System.out.println();

    }

    public static void preOrderRecur(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.val + " ");
        preOrderRecur(node.left);
        preOrderRecur(node.right);
    }

    public static void inOrderRecur(TreeNode node){
        if(node == null){
            return;
        }
        inOrderRecur(node.left);
        System.out.print(node.val + " ");
        inOrderRecur(node.right);
    }

    public static void postOrderRecur(TreeNode node){
        if(node == null){

            return;
        }
        postOrderRecur(node.left);
        postOrderRecur(node.right);
        System.out.print(node.val + " ");
    }

    public static void preOrderUnRecur(TreeNode node){

        if(node != null){
            Stack<TreeNode> stack = new Stack();
            stack.push(node);
            while(!stack.isEmpty()){
                TreeNode cur = stack.pop();
                System.out.print(cur.val + " ");
                if(cur.right != null){
                    stack.push(cur.right);
                }
                if(cur.left != null) {
                    stack.push(cur.left);
                }
            }

        }

    }

    public static void inOrderUnRecur(TreeNode node){

        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

    /**
     * 用两个栈完成后续遍历
     * @param node
     */
    public static void postOrderUnRecur(TreeNode node){

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(node);
        while(!s1.isEmpty()){
            TreeNode cur = s1.pop();
            if(cur.left!=null){
                s1.push(cur.left);
            }
            if(cur.right!=null){
                s1.push(cur.right);
            }
            s2.push(cur);
        }

        while(!s2.isEmpty()){
            System.out.print(s2.pop().val + " " );
        }
    }

    /**
     * 用一个栈完成后续遍历
     * @param node
     */
    public static void postOrderUnRecur2(TreeNode node){
        Stack<TreeNode> s1 = new Stack<>();
        TreeNode lastPop = node;
        TreeNode stackHead = null;

        s1.push(node);
        while(!s1.isEmpty()){
            stackHead = s1.peek();
            TreeNode left = stackHead.left;
            TreeNode right = stackHead.right;
            if(left != null && !lastPop.equals(left) &&  !lastPop.equals(right)){
                s1.push(left);
            } else if(right != null && !lastPop.equals(right)){
                s1.push(right);
            } else {
                TreeNode cur = s1.pop();
                System.out.print(cur.val + " ");
                lastPop = cur;
            }
        }
    }


}
