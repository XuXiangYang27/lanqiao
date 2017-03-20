package 入门训练;

import java.util.Scanner;

public class Begin_3 
{
	public static void main(String[] args)
	{
		int[] arr=new int[1000000];
		int n=new Scanner(System.in).nextInt();
		arr[0]=1;arr[1]=1;
		for (int i = 2; i <n; i++) 
		{
			arr[i]=arr[i-1]%10007+arr[i-2]%10007;
		}
		System.out.println(arr[n-1]%10007);
	}
}
