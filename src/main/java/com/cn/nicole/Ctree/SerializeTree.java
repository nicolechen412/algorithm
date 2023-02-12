package com.cn.nicole.Ctree;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2022/2/9 1:05 下午
 * desc  :
 */

import com.cn.nicole.entity.TreeNode;
import com.cn.nicole.util.TreeUtil;

import java.util.LinkedList;

/**
 *  序列化和反序列化一棵树
 *
 *          先序序列化为字符串：先序递归的方式
 *          先序反序列化为树：借助queue先序递归
 *          层级序列化为字符串：遍历queue来实现层级遍历
 *          层级反序列化为树：遍历queue来实现层级遍历
 *
 */

public class SerializeTree {

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;

//        String str = serialByPre(node1);
//        System.out.println(str);
//        TreeNode head = reconByPreString(str);
//        TreeUtil.pringTreeByPre(head);

        String str1 = serialByLevel(node1);
        System.out.println(str1);

        TreeNode head = reconByLevelString(str1);
        TreeUtil.pringTreeByPre(head);



    }

    /**
     * 按先序序列化
     */
    public static String serialByPre(TreeNode head){

        if(head == null){
            return "#!";
        }
        String result = head.val + "!";
        result += serialByPre(head.left);
        result += serialByPre(head.right);
        return result;
    }

    /**
     * 反序列化先序字符串
     */
    public static TreeNode reconByPreString(String value){
        TreeNode result = null;
        String[] values = value.split("!");
        LinkedList<String> queue = new LinkedList();
        for(int i = 0; i< values.length; i++){
            queue.offer(values[i]);
        }
        result = reconPreOrder(queue);
        return result;
    }

    public static TreeNode reconPreOrder(LinkedList<String> queue){
        TreeNode node = null;
        if(queue.size() == 0){
            return null;
        }
        String cur = queue.poll();
        if(cur.equals("#")){
            return null;
        }
        node = new TreeNode(Integer.valueOf(cur));
        node.left = reconPreOrder(queue);
        node.right = reconPreOrder(queue);
        return node;
    }

    /**
     * 按层级序列化
     */
    public static String serialByLevel(TreeNode head){
        String res = "";
        if(head == null){
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        res += head.val + "!";
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();

            if(cur.left != null){
                queue.offer(cur.left);
                res += cur.left.val + "!";
            } else {
                res += "#!";
            }

            if(cur.right != null){
                queue.offer(cur.right);
                res += cur.right.val + "!";
            } else {
                res += "#!";
            }

        }

        return res;
    }



    /**
     * 反序列化层级字符串
     */
    public static TreeNode reconByLevelString(String value){
        String[] strs = value.split("!");
        TreeNode head = generateNodeByString(strs[0]);
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(head != null){
            queue.offer(head);
        }

        int i = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.pop();
            node.left = generateNodeByString(strs[i++]);
            node.right = generateNodeByString(strs[i++]);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }

        }
        return head;
    }

    public static TreeNode generateNodeByString(String s){
        TreeNode node;
        if(s.equals("#")){
            node = null;
        } else {
            node = new TreeNode(Integer.valueOf(s));
        }
        return node;
    }

}
