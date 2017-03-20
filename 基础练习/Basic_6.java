package 基础练习;

import java.util.Scanner;


public class Basic_6
{
	public static void main(String[] args) 
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		
		int[] a=new int[1000];
		
		for (int i = 0; i <n; i++)
			a[i]=cin.nextInt();
		int flag=0;
		int x=cin.nextInt();
		for (int i = 0; i <n; i++) 
		{
			if (a[i]==x) {
				flag=1;
				System.out.println(i+1);
				break;
			}
		}
		if (flag==0) {
			System.out.println(-1);
		}
	}
}
