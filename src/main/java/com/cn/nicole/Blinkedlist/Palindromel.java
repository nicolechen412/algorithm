package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/9/14 7:33 下午
 * desc  :
 */

import com.cn.nicole.entity.ListNode;
import com.cn.nicole.entity.Stack;
import com.cn.nicole.util.ListUtil;

/**
 * 判断一个链表是否是回文结构
 * 方法1.将整个链表压入栈中，然后一个个出栈和链表表头开始比较。
 * 方法2.使用快慢指针，只将一半的链表压入栈中，然后一个个出栈和后半段链表比较。
 * 方法3.进阶方法：
 */

public class Palindromel {
    public static void main(String[] args) {
//        int[] ints = new int[]{1,2,2,1};
//        int[] ints = new int[]{1,2,3,2,1};
//        int[] ints = new int[]{1};
        int[] ints = new int[]{1,3,4};
        ListNode head = ListUtil.initializeList(ints);
        ListUtil.printList(head);
        Boolean flag = isPalindromel(head);
        System.out.println(flag);


    }

    public static boolean isPalindromel(ListNode head){
        boolean flag = false;

        ListNode fastNode = head;
        ListNode slowNode = head;
        Stack stack = new Stack();
        stack.push(slowNode);
        while(fastNode.next != null && fastNode.next.next != null){

            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            System.out.println("slow : " + slowNode.val + "," + slowNode.next.val);
            System.out.println("fast : " + fastNode.val );
            stack.push(slowNode);

        }

        if(fastNode.next == null){
            stack.pop();
        }
        while(slowNode.next!= null){
            ListNode tmp = stack.pop();
            System.out.println(slowNode.next.val );
            System.out.println( tmp.val );
            if(slowNode.next.val != tmp.val){
                return flag;
            }
            slowNode = slowNode.next;
        }
        flag = true;
        return flag;
    }

}
