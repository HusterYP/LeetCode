/*
题目：
Given an integer, return its base 7 string representation.
Example 1:
Input: 100
Output: "202"
Example 2:
Input: -7
Output: "-10"
Note: The input will be in range of [-1e7, 1e7].
七进制转换
*/

public class Solution {
    public String convertToBase7(int num) {
        String str = "";
		char str1[] = new char[9];
		int flag = 0;
		int k = 8;
		Integer a;
		if(num<0)
		{
			flag = 1;
			num = -num;
		}
		while(num>0)
		{
			a = num%7;
			str += a.toString();
			num /= 7;
		}
		for(char i:str.toCharArray())
			str1[k--] = i;
		return flag==1?"-"+new String(str1):new String(str1);
    }
}