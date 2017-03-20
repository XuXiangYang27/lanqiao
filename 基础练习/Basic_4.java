package 基础练习;

import java.util.Scanner;

import javax.xml.transform.Templates;

public class Basic_4
{
	public static void main(String[] args) 
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		int[] arr=new int[10000];
		for (int i = 0; i < n; i++) {
			arr[i]=cin.nextInt();
		}
		
		long max=arr[0];
		long min=arr[0];
		long sum=0;
		
		for (int i = 0; i <n; i++) 
		{
			sum+=arr[i];
			if (arr[i]>max) {
				max=arr[i];
			}
			if (arr[i]<min) {
				min=arr[i];
			}
		}
		System.err.println(max);
		System.out.println(min);
		System.out.println(sum);
	}
}
