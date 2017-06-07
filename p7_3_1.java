package chapter7;

import java.util.Scanner;

public class p7_3_1 
{
	public static int[] output=new int[10];
	public static int[] input=new int[10];
	static void print_subset(int n,int cur)
	{
		for(int i=0;i<cur;i++)
			System.out.print(output[i]+" ");
		System.out.println();
		
		int s=cur>0?input[cur-1]+1 :0;
		
		for(int i=s;i<n;i++)
		{
			;
		}
		
	}
	public static void main(String[] args) 
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		for(int i=0;i<n;i++)
			input[i]=cin.nextInt();
		
	}
}
