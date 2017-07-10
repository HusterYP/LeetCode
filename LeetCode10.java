/*
题目：
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
*/
/*
总结：
java中如何将char数组转化为String？
1.直接在构造String时建立。 char data[] = {'s', 'g', 'k'}; String str = new String(data);
2.String有方法可以直接转换。 String.valueOf(char[] chr)就可以。 如： char[] cha = {'s','g','h'}; String n = String.valueOf(cha);
注意：
虽然Arrays.toString()方法也可以将char数组转化为String，但是实际上他返回的不是单纯的数组中的字符组成的字符串
*/
public class Solution {
    public String reverseWords(String s) {
        String str[] = s.split(" ");
        String result = new String();
        for(int j=0;j<str.length;j++)
        {
            String a = str[j];
            char arr[] = new char[a.length()];
            for(int i=0;i<arr.length;i++)
                arr[i] = a.toCharArray()[arr.length-1-i];
            if(j!=str.length-1)
                 result+=String.valueOf(arr)+" ";
            else
                 result+=String.valueOf(arr);
        }
        return result;
    }
}