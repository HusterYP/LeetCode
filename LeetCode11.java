/*
题目：
Write a function that takes a string 
as input and returns the string reversed.
Example:
Given s = "hello", return "olleh".
*/

public class Solution {
    public String reverseString(String s) {
        char arr[] = s.toCharArray();
        char temp;
        if(arr.length==0||arr.length==1)
            return s;
        for(int i=0;i<arr.length/2;i++)
        {
            if(arr[i]!=arr[arr.length-i-1])    
            {
                temp = arr[arr.length-1-i];
                arr[arr.length-1-i] = arr[i];
                arr[i] = temp;
            }
        }
        return new String(arr);
    }
}