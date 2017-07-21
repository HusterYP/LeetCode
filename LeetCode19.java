/*
题目：
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
Credits:
Special thanks to @ts for adding this problem and creating all test cases.
思路：
最暴力的解法是排序然后返回中间值，
据说有什么摩尔投票这种东西—_—!
*/

public class Solution {
    public int majorityElement(int[] nums) {
         int n=0;
        for (int i = 0; i <= nums.length/2; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[i] > nums[j])
                {
                    n = nums[j];
                    nums[j] = nums[i];
                    nums[i] = n;
                }
            }
        }
        return nums[nums.length/2];
    }
}