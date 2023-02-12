package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/9/13 9:24 下午
 * desc  :
 */

import com.cn.nicole.entity.ListNode;
import com.cn.nicole.util.ListUtil;

/**
 *
 */

public class JosephusKill {

    public static ListNode josephusKill(ListNode head, int n){
        ListNode node1 = head;
        ListNode node2 = head.next;
        int count = 2;
        while(node1.next != node1){
            if(count % n == 0){
                node1.next = node2.next;
                count = 1;
                node2 = node1.next;
            } else {
                count++;
                node1 = node2;
                node2 = node1.next;
            }

        }
        return node1;

    }

    public static void main(String[] args) {
        ListNode head = ListUtil.initializeList();
//        System.out.println(ListUtil.getTail(head).getValue());
        ListUtil.getTail(head).next = head;
         ListNode newHead = josephusKill(head, 2);
        System.out.println(newHead.getValue());
    }

}
