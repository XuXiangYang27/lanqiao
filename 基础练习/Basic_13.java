package 基础练习;
import java.util.Scanner;
public class Basic_13 
{
	public static void main(String[] args) 
	{
		int n;
		Scanner cin=new Scanner(System.in);
		n=cin.nextInt();		
		int[] arr=new int[200];		
		for (int i = 0; i <n; i++)
			arr[i]=cin.nextInt();

		int temp;
		for (int i = 0; i < n-1; i++) 
			for (int j = 1; j < n-i; j++)
				if (arr[j]<arr[j-1]) 
				{
					temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;				
				}
		for (int i = 0; i < n; i++) 
			System.out.print(arr[i]+" ");
	}
}
