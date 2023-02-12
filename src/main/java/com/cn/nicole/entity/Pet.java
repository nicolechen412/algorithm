package com.cn.nicole.entity;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/4/25 12:54 下午
 * desc  :
 */

public class Pet{

    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}

class Dog extends Pet{
    public Dog() {
        super("Dog");
    }
}

class Cat extends Pet{
    public Cat() {
        super("Cat");
    }
}

