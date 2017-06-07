package chapter7;

import java.util.Scanner;

public class p7_2_1 
{
	public static int[] output=new int[10];
	public static int[] input=new int[10];
	static void print_permutation(int n,int cur)
	{
		if(cur==n)
		{
			for(int i=0;i<n;i++)
				System.out.print(output[i]+" ");
			System.out.println();
		}
		for(int i=0;i<n;i++)
		{
			int c1=0,c2=0;
			for(int j=0;j<cur;j++)
				if(output[j]==input[i])
					c1++;
			for(int j=0;j<n;j++)
				if(input[j]==input[i])
					c2++;
			if(c1<c2)
			{
				output[cur]=input[i];
				print_permutation(n, cur+1);
			}
			
		}
	}
	public static void main(String[] args) 
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		for(int i=0;i<n;i++)
			input[i]=cin.nextInt();
		print_permutation(n, 0);
	}
}
