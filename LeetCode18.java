/*
题目：
Given a word, you need to judge whether the usage of capitals in it is right or not.
We define the usage of capitals in a word to be right when one of the following cases holds:
All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False
思路：
查阅String的方法，配出掉比较简单的全词匹配后，剩下的首字母大写其余小写
可以用String的方法contentEquals来指定比较的位置，可解
*/

public class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.contentEquals(word.toLowerCase())||word.contentEquals(word.toUpperCase())){
            return true;
        }
        if(word.length()>1&&word.regionMatches(false,1,word.toLowerCase(),1,word.length()-1)){
            return true;
        }
        return false;
    }
}