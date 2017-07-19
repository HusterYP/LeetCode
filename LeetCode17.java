/*
题目：
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given two integers x and y, calculate the Hamming distance.
Note:
0 ≤ x, y < 231.
*/
//参看了网上的优解，可以用Integer的bitCount(int i)找出i二进制所包含的1的个数
//以下为用循环找
public class Solution {
    public int hammingDistance(int x, int y) {
       char[]str = Integer.toBinaryString(x^y).toCharArray();
        int count = 0;
        for(int i=0;i<str.length;i++)
            if(str[i]=='1')
                count++;
        return count;
    }
}