/*
��Ŀ��
����һ���������飬�����������ֵ�������ʹ������ӵ�һ���ض���Ŀ�ꡣ
�����Լ���ÿ�����붼ֻ��һ������������������ܲ���ʹ����ͬ��Ԫ�����Ρ�
����
����nums = [2��7��11��15]��target = 9��
��Ϊnums [ 0 ] + nums [ 1 ] = 2 + 7 = 9��
����[ 0��1 ]��
*/
#include<stdio.h>

int *twoSum(int *nums, int numsSize, int target)
{
	int Index[2];//���ص�Ŀ����������
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