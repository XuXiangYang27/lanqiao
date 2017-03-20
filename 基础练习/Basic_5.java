package 基础练习;

import java.util.Scanner;

import javax.xml.transform.Templates;

public class Basic_5
{
	public static void main(String[] args) 
	{
		int[][] arr=new int[34][];
		for (int i = 0; i < 34; i++)
			arr[i]=new int[34];
		for (int i = 0; i < 34; i++)
			arr[i][0]=1;
		int n=new Scanner(System.in).nextInt();
		
		for (int i = 1; i < n; i++)
		{
			for (int j = 1; j < i+1; j++) 
			{
				arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
			}
		}
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < i+1; j++) 
			{
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}	
	}
}
