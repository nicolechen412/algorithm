package com.cn.nicole.util;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2022/2/9 1:12 下午
 * desc  :
 */

import com.cn.nicole.entity.TreeNode;

public class TreeUtil {


    /**
     * 先序遍历方式
     * @param node
     */
    public static void pringTreeByPre(TreeNode node){
        if(node == null){
            return;
        }
        System.out.println("Node : " + node.val +
                ", left : " + (node.left == null ? null : node.left.val) +
                ", right : " + (node.right == null ? null : node.right.val));
        pringTreeByPre(node.left);
        pringTreeByPre(node.right);
    }

}
