package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/12/12 10:10 下午
 * desc  :
 */

import com.cn.nicole.entity.ListNode;

/**
 *  将单链表按某值划分为左边小、中间相等、右边大的形式
 *
 *  我的解题思路：
 *      创建左中右三个链表，每个链表有头尾两个指针，将单向链表中的节点按规则划分到三个链表中，最后将三个链表头尾相连。
 */

public class ListPartition {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode result = listPartition(node1, 4);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode listPartition(ListNode head, int x){
        ListNode tmp = head;
        ListNode left = null;
        ListNode leftHead = null;
        ListNode middle = null;
        ListNode middleHead = null;
        ListNode right = null;
        ListNode rightHead = null;
        while(tmp != null){
            if(tmp.val < x){
                if(left != null){
                    left.next = tmp;
                } else {
                    leftHead = tmp;
                }
                left = tmp;
            } else if(tmp.val == x){
                if(middle != null){
                    middle.next = tmp;
                } else {
                    middleHead = tmp;
                }
                middle = tmp;
            } else {
                if(right != null){
                    right.next = tmp;
                } else {
                    rightHead = tmp;
                }
                right = tmp;
            }
            tmp = tmp.next;
        }

        if(right != null){
            right.next = null;
        }

        if(left != null ){
            left.next = middleHead;
            if( middle != null){
                middle.next = rightHead;
            }
            return leftHead;
        } else if(middle != null){
            middle.next = rightHead;
            return middleHead;
        } else {
            return rightHead;
        }

    }

}
