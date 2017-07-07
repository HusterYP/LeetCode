/*
题目：
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
For example:
Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
Follow up:
Could you do it without any loop/recursion in O(1) runtime?
*/

int addDigits(int num) {
	int sum = num;
    while(sum>9)
	{
		while(num>0)
		{
			sum += num % 10;
			num /= 10;
		}
		num = sum;
	}
	return sum;
}

/*
但是上述解法太过暴力，参看网上解法，
如果整数为100a + 10b + c，
则（100a + 10b + c）％9 =（a + 99a + b + 9b + c）％9 =（a + b + c）％9
那么可以递推下去，最后得到的小于10的数mod 9就相当于是原数 mod 9
但是当原数为9的倍数时要返回9，为特例，因为此时res为0
*/
int addDigits(int num) {
    int res = num % 9;
    return (res != 0 || num == 0) ? res : 9;
}