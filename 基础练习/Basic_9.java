package 基础练习;

import java.util.Scanner;

public class Basic_9
{
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		int a=cin.nextInt();
		int flag=0;
		for(int i=10;i<100;i++)
		{
			for (int j = 0; j < 10; j++) 
			{
				flag=i%10+i/10;
				if (2*flag+j==a) 
				{
					System.out.println(""+i+j+i%10+i/10);
				}
			}
		}
		for(int i=100;i<1000;i++)
		{
			flag=i%10+i/10%10+i/100;
			if (flag*2==a) 
			{
				System.out.println(""+i+i%10+i/10%10+i/100);
			}
		}
	}
}
