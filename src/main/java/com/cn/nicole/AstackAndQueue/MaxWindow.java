package com.cn.nicole.AstackAndQueue;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/6/23 12:55 下午
 * desc  :
 */

import java.util.ArrayDeque;
import java.util.ArrayList;


/**
 * 有一个整数数组arr和一个大小为w的窗口从左滑到右，窗口每次向右滑动一个位置，如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口的最大值。
 * 例如：[4.3.5.4.3.3.6.7]的窗口大小为3时，最大值为{5,5,5,4,6,7}
 *
 * 实现思路：
 * 在遍历过程中，要保证三个条件，
 *  1.只保存窗口大小个数量的值；
 *  2.保证第一个值在窗口范围内；
 *  3.保证如果窗口移动后，最大值是正确的；
 *
 *  所以，使用双端队列，在每一个遍历时，（其实将数组+窗口想象为为只保存窗口范围内数据的双端队列就可以了，包括活动时的变化）
 *      1.如果头元素在窗口外则移除；
 *      2.将当前值与队列中的元素从尾到头比较，小于当前值的从队列中剔除；
 *      3.但是当前值无论大小都加入到队列中（因为如果窗口后移，当前值可能为最大值。所以，只保证队列前面的元素一定大于当前值）
 *      4.为了方便记录元素在数组中的索引，应该将索引入队列。
 *
 *
 */
public class MaxWindow {

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,5,4,3,3,6,7};
        ArrayList<Integer> result = getMaxWindow(arr,3);
        for (int i : result){
            System.out.println(i);
        }
    }

    private static ArrayList getMaxWindow(int[] arr, int winLength) {

        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (!queue.isEmpty() && queue.getFirst() <= i - winLength) {
                queue.removeFirst();
            }
            if (queue.isEmpty()) {
                queue.add(i);
            } else {
                int head = queue.peek();
                if (arr[i] <= arr[head]) {
                    queue.add(i);
                } else {
                    while (!queue.isEmpty()) {
                        if (arr[i] > arr[queue.getFirst()]) {
                            queue.removeLast();
                        } else {
                            break;
                        }
                    }
                    queue.add(i);
                }
            }
            if (i >= 2 && !queue.isEmpty()) {
                int length = queue.getFirst();
                result.add(arr[length]);
            }
        }
        return result;
    }

    //答案版本
    private static ArrayList getMaxWindow1(int[] arr, int winLength) {

        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (!queue.isEmpty() && queue.peekFirst() <= i - winLength) {
                queue.removeFirst();
            }
            queue.add(i);
            while (!queue.isEmpty()) {
                if (arr[i] > arr[queue.peekFirst()]) {
                    queue.removeLast();
                } else {
                    break;
                }
            }
            if (i >= winLength-1 && !queue.isEmpty()) {
                int length = queue.peekFirst();
                result.add(arr[length]);
            }
        }
        return result;
    }


}
