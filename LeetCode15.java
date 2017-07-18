/*
题目：
Given two strings s and t which consist of only lowercase letters.
String t is generated by random shuffling string s and then add one more letter at a random position.
Find the letter that was added in t.
Example:
Input:
s = "abcd"
t = "abcde"
Output:
e
Explanation:
'e' is the letter that was added.
*/

//通常找二者之间的不同，用^操作将所有数据都轮询一遍，剩下的就是不同的

public class Solution {
    public char findTheDifference(String s, String t) {
        char c = t.charAt(0);
     for (int i = 0; i < s.length(); i++)
        {
             c ^= s.charAt(i);
             c ^= t.charAt(i+1);
        }
        return c;
    }
}