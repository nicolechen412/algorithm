package com.cn.nicole.Blinkedlist;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/12/20 12:58 下午
 * desc  :
 */

import com.cn.nicole.entity.ListNode;
import com.cn.nicole.util.ListUtil;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Stack;

/**
 * 单链表中删除指定值的节点
 *
 * 方法一：将不等于指定值的节点放入栈中，然后重新取出组成链表，时间复杂度O(N)，空间复杂度O(N)
 * 方法二：直接遍历链表，时间复杂度O(N)，空间复杂度O(1)
 */
public class RemoveValue {

    public static void main(String[] args) {

        ListNode head = ListUtil.initializeList(1,2,3,4,3,3,3,5);
//        ListNode newHead = removeValue(head, 3);
        ListNode newHead = removeValue2(head, 3);
        ListUtil.printList(newHead);

    }

    public static ListNode removeValue(ListNode head, int num){
        ListNode tmp = head;
        Stack<ListNode> stack = new Stack();
        while(tmp != null){
            if(tmp.val != num){
                stack.push(tmp);
            }
            tmp = tmp.next;
        }
        ListNode node = null;
        if(stack != null){
            node = stack.pop();
        }

        while(!stack.isEmpty()){
            stack.peek().next = node;
            node = stack.pop();
        }
        return  node;
    }

    public static ListNode removeValue2(ListNode head, int num){
        ListNode tmp = head;
        ListNode pre = head;
        ListNode newHead = head;
        while(tmp != null){
            if(tmp.val != num){
                pre = tmp;
                tmp = tmp.next;

            } else {
                if(tmp.equals(newHead)){
                    newHead = tmp.next;
                    tmp = tmp.next;
                } else {
                    pre.next = tmp.next;
                    tmp = tmp.next;
                }
            }
        }
        return newHead;

    }

}
