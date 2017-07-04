/*
 * Given a positive integer, output its complement number. 
The complement strategy is to flip the bits of its binary representation.
Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits),
 and its complement is 010. So you need to output 2.
Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), 
and its complement is 0. So you need to output 0.
 * */

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class Demo
{
	public static void main(String[]agrs)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个正整数：");
		Integer m = new Integer(scan.nextInt());
		String string = m.toBinaryString(m);
		char num[] = string.toCharArray();
		int count = 0;
		for (int i=0;i<num.length;i++)
		{
			System.out.println(num[i]);
			if(num[i] == '0')
			{
				count += Math.pow(2,num.length-i-1);
			}
		}
		System.out.println(count);
	}
}