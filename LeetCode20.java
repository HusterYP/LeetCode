/*
题目：
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
*/

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = 0;
        for(int i=0;i<nums.length;i++){
            n = Math.abs(nums[i]);
			if(nums[n-1]>0)
            nums[n-1] = -n;
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                result.add(i+1);
        }
        return result;
    }
}