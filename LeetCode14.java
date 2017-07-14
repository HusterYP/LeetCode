/*
题目：
Write a program that outputs the string representation of numbers from 1 to n.
But for multiples of three it should output “Fizz” instead of the number and for
the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
Example:
n = 15,
Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
*/

public class Solution {
    public List<String> fizzBuzz(int n) {
        String str1 = "Fizz";
        String str2 = "Buzz";
        String str3 = "FizzBuzz";
        ArrayList<String>result = new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            if(i%3==0 && i%5!=0)
                result.add(str1);
            else if(i%5==0&&i%3!=0)
                result.add(str2);
            else if(i%3==0&&i%5==0)
                result.add(str3);
            else
                result.add(i+"");
        }
        return result;
    }
}