package com.cn.nicole.JBackTracking;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 11/4/22 10:14 PM
 * desc  :
        给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
        示例 1：
            输入：nums = [1,2,3]
            输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

         https://leetcode.cn/problems/permutations/
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute {
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = new int[]{0,1};
        System.out.println(permute(nums));



    }

    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>(); //不使用linkedlist无法准确移除回溯结束的那个元素
        boolean[] uses = new boolean[nums.length];
         backTrack(path, uses, nums);
         return result;
    }

    private static void backTrack(LinkedList<Integer> path, boolean[] uses, int[] nums) {

        if(path.size() == nums.length){
            result.add(new LinkedList<>(path));  // 不使用new 会变成引用
            return ;
        }
        for(int i = 0; i< nums.length; i++){
            if(uses[i]){
                continue;
            }
            path.add(nums[i]);
            uses[i] = true;
            backTrack(path, uses, nums);
            path.removeLast();
            uses[i] = false;
        }




    }


}
