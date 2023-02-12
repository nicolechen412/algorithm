package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/12/16 1:08 下午
 * desc  :
 */

import com.cn.nicole.entity.ListNode;

/**
 * 将单链表的每k个节点逆序
 *
 * 解法：
 *      方法一：每k个节点压入栈中，然后将节点出栈组成链表 空间复杂度O(k)
 *      方法二：在当前链表做逆序操作 空间复杂度O(1) （本题解法）
 */
public class ReverseKNodes {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        ListNode head = reverseKNodes(node1, 4);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode reverseKNodes(ListNode head, int k) {

        ListNode last = null;
        ListNode next = null;

        ListNode first = head;
        ListNode second = null;
        ListNode third = null;
        ListNode newHead = null;

        ListNode tmp = head;
        int count = 0;
        while(tmp != null){
            count++;
            if(count % k == 1){
                first = tmp;
                tmp = tmp.next;
            } else if(count % k == 0){
                next = tmp.next;
                if(last != null){
                    last.next = tmp;
                } else {
                    newHead = tmp;
                }
                last = first;
                second = first.next;
                third = second.next;
                //逆序
                first.next = next;
                while(second != next){
                    second.next = first;
                    first = second;
                    second = third;
                    if(third != null){
                        third = third.next;
                    }

                }
                tmp = next;
            } else {
                tmp = tmp.next;
            }

        }
        return newHead;

    }

}
