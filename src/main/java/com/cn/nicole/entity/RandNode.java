package com.cn.nicole.entity;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/12/13 10:36 下午
 * desc  :
 */

public class RandNode {

    public int val;
    public RandNode next;
    public RandNode rand;


    public RandNode(int value) {
        this.val = value;
    }

    public RandNode(int value, RandNode next, RandNode rand) {
        this.val = value;
        this.next = next;
        this.rand = rand;
    }
}
