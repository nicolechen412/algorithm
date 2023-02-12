package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/12/14 9:47 下午
 * desc  :
 */

/**
 * 两个链表生成相加链表
 *
 * 解法:
 *      解法1：使用两个栈，将两个链表的节点放入，然后倒着挨个取出，从个位开始，进行每个位的进位加法计算，并组成链表。
 *      解法2：节省栈空间，先将两个链表逆序，按照解法1遍历计算，最后再将两个链表逆序
 */

import com.cn.nicole.entity.ListNode;

import java.util.Stack;

public class AddList {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node01 = new ListNode(3);
        ListNode node02 = new ListNode(6);
        head1.next = node01;
        node01.next = node02;

        ListNode head2 = new ListNode(9);
        ListNode node11 = new ListNode(6);
        ListNode node12 = new ListNode(7);
        head2.next = node11;
        node11.next = node12;

        ListNode result = addList(head1, head2);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
//        System.out.println("result: " + result);
    }

    public static ListNode addList(ListNode head1, ListNode head2){
        int ca = 0;
//        int result = 1;
        Stack<ListNode> stack1 = new Stack();
        Stack<ListNode> stack2 = new Stack();
        ListNode tmp1 = head1;
        //将两个链表放入栈中
        while(tmp1 != null){
            stack1.push(tmp1);
            tmp1 = tmp1.next;
        }
        ListNode tmp2 = head2;
        while(tmp2 != null){
            stack2.push(tmp2);
            tmp2 = tmp2.next;
        }
        ListNode pre = null;
        //遍历栈
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            int a = stack1.isEmpty() ? 0 : stack1.pop().val;
            int b = stack2.isEmpty() ? 0 : stack2.pop().val;

            int single = (a + b + ca)  % 10;
            if(a + b + ca >= 10){
                ca = 1;
            } else {
                ca = 0;
            }
            if(pre == null){
                pre = new ListNode(single);
            } else {
                ListNode node = new ListNode(single);
                node.next = pre;
                pre = node;
            }
        }

        if(ca == 1){
            ListNode node = new ListNode(1);
            node.next = pre;
            pre = node;
        }
        return pre;

    }
}
