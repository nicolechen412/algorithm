package com.cn.nicole.JBackTracking;
/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 11/7/22 10:32 PM
 * desc  :
 *      给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
        解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *  示例 1：
        输入：nums = [1,2,3]
        输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

 * https://leetcode.cn/problems/subsets/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> track = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        subsets(nums);
        System.out.println(result);

    }

    public static List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return result;
    }

    private static void backtrack(int[] nums, int n) {
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return;
        }
        result.add(new ArrayList<>(track));
        for (int i = n; i < nums.length; i++) {
            track.addLast(nums[i]);
            backtrack(nums, i + 1);      //注意这里，传入的是i而不是n，如果是n的话 每轮递归结束 添加的元素不会往前走，会重复添加
            track.removeLast();

        }
    }

}
