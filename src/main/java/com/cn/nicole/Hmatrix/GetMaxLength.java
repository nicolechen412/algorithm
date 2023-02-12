package com.cn.nicole.Hmatrix;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2022/2/15 12:43 下午
 * desc  :
 */


/**
 * 未排序正数数组中累加和为给定值的最长子数组长度。时间复杂度O(N),额外空间复杂度O(1)
 *
 * 解题思路：
 *      使用left和right指针记录，累加超过给定值left指针向右移动，累加不够则移动right指针向右移动
 */
public class GetMaxLength {

    public static void main(String[] args) {
        int[] arr = {1,2,1,1,1,1,4};
        int result = getMaxLength(arr,3);
        System.out.println(result);

    }

    public static int getMaxLength(int[] arr, int k){

        int left = 0;
        int right = 0;
        int sum = arr[0];
        int len = 0;
        if(arr.length == 0 && k <= 0){
            return 0;
        }
        while (right < arr.length){
            if(sum == k){
                len = Math.max(right - left + 1, len);
                sum -= arr[left++];
            } else if (sum < k){
                right += 1;
                if(right == arr.length){
                    break;
                }
                sum += arr[right];
            } else {
                sum -= arr[left++];
            }
        }
        return len;

    }

}
