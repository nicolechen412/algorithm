package com.cn.nicole.Hmatrix;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2022/2/15 1:17 下午
 * desc  :
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 未排序数组中累加和为给定值的最长子数组长度。时间复杂度O(N),额外空间复杂度O(N)
 *
 * 解题思路：
 *      比较复杂。
 *      如果当前满足子数组累加值等于给定k，则一定存在sum-k的累加值存在。所以用map只保存第一个满足sum-k的索引，
 *      用当前索引减去sum-k的索引一定是等于给定值的的最长子数组长度。
 *
 *      要在map中保存sum为0的索引-1，则会存在找不到从数组第一个元素开始的满足k的子数组索引。
 *
 *      如果不要求时间复杂度O(N)，则是指数级全局遍历比较最长路径。
 */
public class GetMaxLength2 {


    public static void main(String[] args) {

//        int[] arr = new int[]{4,1,-3,1,1,1};
//        System.out.println(getMaxLength(arr, 3));
//
        int[] arr2 = new int[]{-2,3,-4,0,-5,5,7,9};
        System.out.println(getMaxLength2(arr2));

        int[] arr3 = new int[]{0,0,0,0,1,1,0,1,0,0,1,1,1};
        System.out.println(getMaxLength3(arr3));


    }

    public static int getMaxLength(int[] arr, int k){
        int len = 0;
        //存放第一次累加值达到key时的子数组长度
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,-1);
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum-k)){
                len = Math.max(i - map.get(sum-k), len);
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return len;
    }

    /**
     * 补充：给定一个数组，其中元素可正可负可0，求所有子数组中正数与负数个数相等的最长子数组长度。时间复杂度O(N),额外空间复杂度O(N)
     */
    public static int getMaxLength2(int[] arr){

        int len = 0;
        int sum = 0;
        //key为索引存在的正负数差值，value为当前数组索引
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0){
                sum --;
            } else if(arr[i] > 0){
                sum ++;
            }
        
            if(!map.containsKey(sum)){
                map.put(sum, i);
            } else {
                len = Math.max(i - map.get(sum), len);
            }
        }
        return len;
    }

    /**
     * 补充：给定一个数组，其中元素只有0和1，求所有子数组中0与1个数相等的最长子数组长度。时间复杂度O(N),额外空间复杂度O(N)
     * @param arr
     * @param k
     * @return
     */
    public static int getMaxLength3(int[] arr){

        int len = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {

            if(arr[i] == 1){
                sum++;
            } else {
                sum--;
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            } else {
                len = Math.max(i - map.get(sum), len);
            }

        }
        return len;
    }

}
