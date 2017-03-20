package 基础练习;

import java.util.Scanner;


public class Basic_2
{
	public static void main(String[] args) 
	{
		Scanner cin=new Scanner(System.in);
		
		int n=cin.nextInt();
		int m=cin.nextInt();
		
		char[][] arr=new char[26][];
		for (int i = 0; i < n; i++)
			arr[i]=new char[26];
		
		for (int i = 0; i < n; i++) 
		{
			for (int j = i; j < m; j++) 
				arr[i][j]=(char)(65+j-i);
			for (int j = i; j < n; j++) 
				arr[j][i]=(char)(65+j-i);
		}
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < m; j++) 
				System.out.print(arr[i][j]);
			System.out.println();
		}
	}
}
