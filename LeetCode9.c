/*
题目：
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
*/

int findComplement(int num) {
    int count = 0;
    int n = num;
    while(num>0)
    {
        num /= 2;
        count++;
    }
    return (int)pow(2,count)-1-n;
}