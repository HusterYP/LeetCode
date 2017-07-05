��Ŀ�� 
Given an array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

//�ҵĽⷨ
public class Demo
{
	public static int singleNumber(int[]num)
	{
		Arrays.sort(num);
		if(num[num.length-1] != num[num.length-2])
			return num[num.length-1];
		if(num[0]!=num[1])
			return num[0];
		for(int i=0;i<num.length-2;i++)		
			if(num[i] != num[i+1]&&num[i+1]!=num[i+2])
				return num[i+1];
		return -1;
	}
	public static void main(String[]args)
	{
		int num[] = {2,2,3,3,1,4,4,5,5};
		System.out.println(singleNumber(num));
	}
}

/*
����������Ž�
˼·��
ʹ��������������forѭ���ȼ���һ���԰����е�ֵ��������λ����
�ɴ˿��ԱȽ����׵����
���������Ҫ��һ��forѭ��ȫ�ֵȼ۵�˼��
*/

public class Demo
{
	public static int singleNumber(int []num)
	{
		int result = num[0];
//		int result = 0;//���Ҳ���ԣ�����Ҫ��iΪ0��ʼ������Ҫ��ʼֵΪ0���У���Ϊֻ��0�Ŷ����Ľ��û��Ӱ��
		for(int i=1;i<num.length;i++)
		{
			System.out.print(result+"  ");
			result ^= num[i];
		}
		return result;
	}
	public static void main(String[]args)
	{
//		int []num = {1,1,2,2,3,4,4,5,5};
		int []num = {1,2,1,2,3,4,5,4,5};
		int result = singleNumber(num);
		System.out.println(result);
	}
}
