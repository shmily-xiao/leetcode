package com.leetcode.code;

/**
 * Created by root on 16-9-30.
 */
public class TwoSum {
    public static void main(String[] args){
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums,target);

        if (result!=null) {
            System.out.print(result[0]);
            System.out.print(result[1]);
        }
    }

    private static int[] twoSum(int[] nums,int target){
        for (int i = 0;i < nums.length; i++){
            for (int j = i+1;j<nums.length;j++){
                if (nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
