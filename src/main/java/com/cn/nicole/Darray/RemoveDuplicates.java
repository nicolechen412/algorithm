package com.cn.nicole.Darray;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 10/27/22 10:48 PM
 * desc  :
 */

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int result = removeDuplicates(nums);
        System.out.println(result);
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0)
        {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while(fast < nums.length){
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }

}
