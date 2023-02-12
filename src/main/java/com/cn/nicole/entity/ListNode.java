package com.cn.nicole.entity;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/9/13 12:53 下午
 * desc  :
 */

public class  ListNode implements Comparable< ListNode>{
    public int val;
    public  ListNode next;

    public  ListNode(int value) {
        this.val = value;
    }

    public  ListNode getNext() {
        return next;
    }

    public void setNext( ListNode next) {
        this.next = next;
    }

    public int getValue() {
        return val;
    }

    public void setValue(int value) {
        this.val = value;
    }

    @Override
    public String toString() {
        return " ListNode{" +
                "value=" + val +
                '}';
    }

    @Override
    public int compareTo( ListNode o) {
        if(this.val > o.val){
            return 1;
        } else if(this.val < o.val){
            return -1;
        }
        return 0;
    }
}
