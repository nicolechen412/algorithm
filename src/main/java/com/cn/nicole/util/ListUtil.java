package com.cn.nicole.util;

/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/9/13 12:58 下午
 * desc  :
 */

import com.cn.nicole.entity.ListNode;

public class ListUtil {

    public static void printList(ListNode head){
        System.out.println();
        ListNode tmp = head;
        int i = 1;
        while (tmp != null){
            System.out.println("Node" + i++ + " : " + tmp.getValue());
            tmp = tmp.next;
        }
    }


    public static ListNode initializeList(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        return node1;
    }

//    public static ListNode initializeList(int[] ints){
//        ListNode head = null;
//        ListNode pre = null;
//        for(int i = 0 ; i < ints.length; i++){
//            ListNode node = new ListNode(ints[i]);
//            if(i == 0){
//                head = node;
//                pre = node;
//            } else {
//                pre.next = node;
//                pre = node;
//            }
//
//        }
//        return head;
//    }

    public static ListNode initializeList(int... ints){
        ListNode head = null;
        ListNode pre = null;
        for(int i = 0 ; i < ints.length; i++){
            ListNode node = new ListNode(ints[i]);
            if(i == 0){
                head = node;
                pre = node;
            } else {
                pre.next = node;
                pre = node;
            }

        }
        return head;
    }

    public static ListNode getTail(ListNode head){
        ListNode tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        return tmp;
    }

}
