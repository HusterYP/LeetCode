/*
题目：
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
Examples:
s = "leetcode"
return 0.
s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
思路：
找第一个为重复的字母，可以使用String类型的indexof方法找索引，如果索引值和当前其所在位置相同，
那么还要判断其后是否还出现该字母，若为出现，则返回索引值，即所求
*/
public class Solution {
    public int firstUniqChar(String s) {
        char[] str = s.toCharArray();
        int t = 0;
        for (int i = 0; i < str.length; i++)
        {
            if ((t = s.indexOf(str[i])) == i)
            {
                if (s.indexOf(str[i],t+1)==-1){
                    return i;
                }
            }
        }
        return -1;
    }
}