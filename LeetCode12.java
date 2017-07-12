/*
题目：
Given a List of words, return the words that can be typed using letters of alphabet 
on only one row's of American keyboard like the image below.
Example 1:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
Note:
You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.
*/

/*
思路：
这里涉及到如何判断字符在给定的一串字符串中，
如何将ArrayList<String>的值转换为String[]类型，注意对于Integer等类型都是一样的
还有要注意一下基本数据类型数组的定义方式
int[]arr = {1,2,3};
int[]arr = new int[3];
int[]arr = new int[]{1,3,4,5};
注意基本上就这三种，对于int arr[3]={1,2,3};
之类的是错误的，这个不同于其他语言。。（比如C语言中就可以）
*/
public class Solution {
    public String[] findWords(String[] words) {
        String str[] = {"asdfghjklASDFGHJKL","qwertyuiopQWERTYUIOP","zxcvbnmZXCVBNM"};
        ArrayList<String>result = new ArrayList<>();
        int flag[]={0,0,0};
        for(String s:words)
        {
            flag[0] = 0;
            flag[1] = 0;
            flag[2] = 0;
            for(int i=0;i<s.toCharArray().length;i++)
            {
                if(str[0].indexOf(s.toCharArray()[i])!=-1)
                {
                    flag[0]=1;
                    continue;
                }
                else if(str[1].indexOf(s.toCharArray()[i])!=-1)
                {
                    flag[1]=1;
                    continue;
                }
                else
                {
                    flag[2]=1;
                    continue;
                }
            }
            if(flag[0]+flag[1]+flag[2]==1)
               result.add(s);
        }
        return (String[])result.toArray(new String[0]); 
    }
}