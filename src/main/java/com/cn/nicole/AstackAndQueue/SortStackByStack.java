package com.cn.nicole.AstackAndQueue;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/6/21 12:49 下午
 * desc  :
 */


import java.util.Stack;

/**
 * 05.使用一个栈实现另一个栈的排序
 *
 * 错误实现：
 * 使用cur和原始stack的栈顶比较，在cur大于和小于两种情况时的处理不一样。
 * cur是每次循环从stack中取出的，与stack新的栈顶比较，如果cur小于，则再次pop（要求本次循环stack数量大于1）。而大于时则直接放入helpStack（要求stack数量大于0）。两种情况对stack的数量要求不一样。
 *
 * 应该使用stack的栈顶和helpstack的栈顶比较，helpstack为空则直接放入。
 * 要维护helpstack的顺序，则应该专注于helpstack中顺序。
 */
public class SortStackByStack {


    public static void sortStackByStack(Stack<Integer> stack) {

        Stack<Integer> helpStack = new Stack<>();
        while(!stack.isEmpty()){
            int cur = stack.pop();
            while(!helpStack.isEmpty() && helpStack.peek() < cur){
                stack.push(helpStack.pop());
            }
            helpStack.push(cur);
        }
        while (helpStack.size() != 0) {
            stack.push(helpStack.pop());
        }

    }




    public static void main(String[] args) {


        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(1);

        sortStackByStack(stack);

        while (stack.size() != 0) {
            System.out.println(stack.pop());
        }
    }


}
