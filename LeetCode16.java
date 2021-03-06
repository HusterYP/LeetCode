/*
题目：
Given an array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
//同时上一题一样的思路，都是轮询用^

public class Solution {
    public int singleNumber(int[] nums) {
        int n = nums[0];
        for(int i=1;i<nums.length;i++){
            n ^= nums[i];
        }
        return n;
    }
}