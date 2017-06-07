package chapter7;

import java.util.Scanner;

public class p7_2_2 
{
	public static int[] array=new int[10];
	
	static void print_permutation(int n,int cur)
	{
		if(cur==n)
		{
			for(int i=0;i<n;i++)
				System.out.print(array[i]+" ");
			System.out.println();
		}
		for(int i=0;i<n;i++)
		{
			int ok=1;
			for(int j=0;j<cur;j++)
				if(array[j]==1+i)
					ok=0;
			if(ok==1)
			{
				array[cur]=i+1;
				print_permutation(n, cur+1);
			}
			
		}
	}
	public static void main(String[] args) 
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		
		print_permutation(n, 0);
	}
}
