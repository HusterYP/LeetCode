/*
题目：
给定一个整数数组，返回两个数字的索引，使它们相加到一个特定的目标。
您可以假设每个输入都只有一个解决方案，而您可能不会使用相同的元素两次。
例：
给定nums = [2，7，11，15]，target = 9，
因为nums [ 0 ] + nums [ 1 ] = 2 + 7 = 9，
返回[ 0，1 ]。
*/

public class Demo
{
	public boolean twoSum(int nums[],int target,int Index[])
	{
		if(target<=2)
			return false;
		for(int i=0;i<nums.length-1;i++)
		{
			for(int j=i+1;j<nums.length;j++)
				if(target==nums[j]+nums[i])
				{
					Index[0] = i;
					Index[1] = j;
					return true;
				}
		}
		return false;
	}
	public static void main(String[]args)
	{
		int nums[] = {2,11,15,4,7,3};
		int Index[] = new int[2];
		int target = 9;
		Demo demo = new Demo();
		boolean bool = demo.twoSum(nums,target,Index);
		if(bool)
			System.out.println(Index[0] + "  " + Index[1]);
		else
			System.out.println("Not Found!");
	}
}