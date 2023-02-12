package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/12/27 9:28 下午
 * desc  :
 */

import com.cn.nicole.entity.ListNode;
import com.cn.nicole.util.ListUtil;

/**
 * 合并两个链表。一定要用虚拟头结点，否则算法会复杂很多。
 */

public class Merge {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
       ListNode node2 = new ListNode(2);
       ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

       node1.next = node2;
       node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        // ListNode head = merge(node1, node4);
        ListNode head = mergeTwoLists(node1, node4);
        ListUtil.printList(head);

    }

    public static ListNode merge(ListNode node1, ListNode node2){
        ListNode newHead = null;

        if(node1 == null){
            return node2;
        }
        if(node2 == null){
            return node1;
        }

        ListNode tmp1 = node1;
        ListNode tmp2 = node2;
        ListNode cur = null;
        while ( tmp1 != null && tmp2 != null){
            if(newHead == null){
                if( tmp1.val <= tmp2.val){
                    newHead = tmp1;
                    tmp1 = tmp1.next;
                } else {
                    newHead = tmp2;
                    tmp2 = tmp2.next;
                }
                cur = newHead;
            } else {
                if( tmp1.val <= tmp2.val){
                    cur.next = tmp1;
                    tmp1 = tmp1.next;
                } else {
                    cur.next = tmp2;
                    tmp2 = tmp2.next;
                }
                cur = cur.next;
            }
        }
        if(tmp1 == null){
            cur.next = tmp2;
        } else {
            cur.next = tmp1;
        }



        return newHead;
    }


        public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode head = new ListNode(-1);
            ListNode p = head;
            if(list1 == null){
                return list2;
            }
            if(list2 == null){
                return list1;
            }
            while(list1 != null && list2 != null){
                if(list1.val < list2.val){
                    p.next = list1;
                    p = p.next;
                    list1 = list1.next;

                } else {
                    p.next = list2;
                    p = p.next;
                    list2 = list2.next;
                }
            }

            if(list1 != null){
                p.next = list1;
            }
            if(list2 != null){
                p.next = list2;
            }

            return head.next;
        }


}
