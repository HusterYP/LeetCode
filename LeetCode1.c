/*
题目：
给定一个整数数组，返回两个数字的索引，使它们相加到一个特定的目标。
您可以假设每个输入都只有一个解决方案，而您可能不会使用相同的元素两次。
例：
给定nums = [2，7，11，15]，target = 9，
因为nums [ 0 ] + nums [ 1 ] = 2 + 7 = 9，
返回[ 0，1 ]。
*/
#include<stdio.h>

int *twoSum(int *nums, int numsSize, int target)
{
	int Index[2];//返回的目标索引数组
	if (numsSize <= 2)
		return NULL;
	for (int i = 0; i < numsSize - 1; i++)
	{
		for (int j = i+1; j < numsSize; j++)
		{
			if (nums[j] + nums[i] == target)
			{
				Index[0] = i;
				Index[1] = j;
				return Index;
			}
		}
	}
	return NULL;
}
int main()
{
	int nums[] = { 2,7, 11, 15};
	int target = 9;
	int *p;
	p = twoSum(nums, 4, target);
	if (p != NULL)
		printf("%d\t%d", p[0], p[1]);
	else
		printf("Not Found !");
	return 0;
}