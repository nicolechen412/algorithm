package com.cn.nicole.entity;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/9/14 7:45 下午
 * desc  :
 */

public class Stack {

    private int length;
    private ListNode[] nodes;
    private int count = 0;

    public Stack(int length) {
        nodes = new ListNode[length];
    }

    public Stack() {
        length = 100;
        nodes = new ListNode[100];
    }

    public ListNode pop(){
//        System.out.println("count: "+ count);
        if(count >= 0){
//            System.out.println("pop: "  + count);
            ListNode tmp = nodes[--count];
//            System.out.println("tmp "+ tmp.val);
            return tmp;
        } else {
            System.out.println("Stack is null");
            return null;
        }
    }

    public void push(ListNode tmp){
        if(count < length){
            nodes[count++] = tmp;
//            System.out.println("push count:" + count);
        } else {
            System.out.println("Stack is full");
        }
    }
}
