/*
题目：
Given an integer array with even length, where different numbers in this array
represent different kinds of candies. Each number means one candy of the corresponding kind. 
You need to distribute these candies equally in number to brother and sister. 
Return the maximum number of kinds of candies the sister could gain.
Example 1:
Input: candies = [1,1,2,2,3,3]
Output: 3
Explanation:
There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
The sister has three different kinds of candies.
Example 2:
Input: candies = [1,1,2,3]
Output: 2
Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
The sister has two different kinds of candies, the brother has only one kind of candies.
Note:
1.The length of the given array is in range [2, 10,000], and will be even.
2.The number in given array is in range [-100,000, 100,000].
*/
/*
 题的关键在于找不同的种类数；
 难点在于 如何减少时间复杂度
 看了论坛的讨论，用哈希值可以降低复杂度，但是目前还不会，就用常规方法解了
*/
public class Demo
{
    public int distributeCandies(int[] candies)
    {
    	Arrays.sort(candies);
    	int count = 0;
    	int i = 0;
    	for(i=0;i<candies.length - 1;i++)
    	{
    		if(candies[i]!=candies[i+1])
    			count++;
    	}
    	if(candies[i]==candies[i-1])
    		count++;
    	if(count<candies.length/2)
    		return count;
    	else 
    		return candies.length/2;
    }
	public static void main(String[]args)
	{
		Demo demo = new Demo();
		int candies[] = {1,1,2,2,3,3};
		int kind = demo.distributeCandies(candies);
		System.out.println("kind = "+kind);
		
	}
}