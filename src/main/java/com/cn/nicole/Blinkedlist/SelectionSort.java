package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/12/26 8:29 下午
 * desc  :
 */

import com.cn.nicole.entity.ListNode;
import com.cn.nicole.util.ListUtil;

/**
 * 单链表的选择排序，额外空间复杂度O(1)
 *
 *      写的太恶心了 重新写
 */

public class SelectionSort {

    public static void main(String[] args) {
        ListNode head = ListUtil.initializeList(5,2,1,3,4);
        ListNode newHead = selecionSort(head);
        ListUtil.printList(newHead);

    }

    public static ListNode selecionSort(ListNode head){

        ListNode newHead = null;
        ListNode cur = head;
        ListNode min = null;
        ListNode newLast = null;
        ListNode newPre = null;
        while(cur != null){
            //获取最小值的前一个节点
            newPre = getSmallestPreNode(cur);
            //修改原始链表，将最小节点取出
            if(newPre != null){
                min = newPre.next;
                if(min.next != null){
                    newPre.next = newPre.next.next;
                } else {
                    newPre.next = null;
                }
            }else {
                min = cur;
                if(cur.next != null){
                    cur = cur.next;
                }
            }
            //连接新链表
            if(newHead == null){
                newHead = min;
                newHead.next = null;
            } else {
                if(newHead.next == null){
                    newLast = min;
                    newHead.next = newLast;
                }else {
                    newLast.next = min;
                    newLast = newLast.next;
                }
            }
            //将最后一个节点接入新链表
            if(cur.next == null){
                if(newLast == null) {
                    newLast = cur;
                    newHead.next = newLast;
                } else {
                    newLast.next = cur;
                }
                return newHead;
            }
        }
        return newHead;

    }

    private static ListNode getSmallestPreNode(ListNode cur) {
        ListNode min = cur;
        ListNode pre = cur;
        ListNode newPre = null;
        while(cur != null){
            if(cur.val < min.val){
                min = cur;
                newPre = pre;
            }
            pre = cur;
            cur = cur.next;
        }
        return newPre;
    }

}
