package com.cn.nicole.Ctree;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2022/2/14 11:18 下午
 * desc  :
 */

import com.cn.nicole.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 在二叉树中找到累加和为指定值的最长路径长度。时间复杂度O(N),额外空间复杂度O(N)。
 *
 * 注意：每次只能选择一个孩子节点，所以该最长路径的长度不会超过树的层数。 记录经过的层级表示路径长度
 *      解题过程参考：src/main/java/com/cn/nicole/Hmatrix/GetMaxLength2.java
 */

public class GetMaxLength {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-3);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(-9);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(2);
        TreeNode node7 = new TreeNode(1);
        TreeNode node8 = new TreeNode(1);
        TreeNode node9 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        System.out.println(getMaxLenght(node1, -9));
    }

    public static int getMaxLenght(TreeNode node, int sum){

        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        return preOrder(node,sum,0,1,0, map);



    }

    private static int  preOrder(TreeNode head, int sum, int preSum, int level, int maxLen, HashMap<Integer, Integer> sumMap) {

        if(head == null){
            return maxLen;
        }

        int curSum = preSum + head.val;

        if( sumMap.containsKey(curSum - sum)){
            maxLen = Math.max(level - sumMap.get(curSum - sum), maxLen);

        }
        if(!sumMap.containsKey(curSum)){
            sumMap.put(curSum, level);
        }

        maxLen = preOrder(head.left, sum, curSum, level+1, maxLen, sumMap);
        maxLen = preOrder(head.right, sum, curSum, level+1, maxLen, sumMap);

        //当前节点已经遍历完成，跳回上一层节点，因为一层只取一个节点作为路径的组成，为不影响sum，需要将当前路径的结果删除
        if(level == sumMap.get(curSum)){
            sumMap.remove(curSum);
        }

        return maxLen;


    }

}
