/*
题目：
Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
Example 1:
Input: [1,4,3,2]
Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].
*/
/*
思路:
由于数组中的最大值肯定取不到，但是可以取到次最大值，
由此类推，由上而下，类似于递归的思想；
故先排序，然后两两成对，取小值相加
*/
#include<stdio.h>

int arrayPairSum(int* nums, int numsSize) 
{
	int temp;
	int sum = 0;
	//排序
	for (int i = 0; i < numsSize-1; i++)
	{
		for (int j = i+1; j < numsSize; j++)
		{
			if (nums[i]>nums[j])
			{
				temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		if (i % 2 == 0)
		{
			sum += nums[i];//最小值相加
		}
	}
	return sum;
}
int main()
{
	int nums[] = { 1, 4, 3, 2 };
	int sum = arrayPairSum(nums, 4);
	printf("sum=%d", sum);
	return 0;
}