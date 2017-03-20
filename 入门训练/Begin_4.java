package 入门训练;

import java.util.Scanner;

public class Begin_4 
{
	public static void main(String[] args)
	{
		long n=new Scanner(System.in).nextLong();
		if (n%2==0)
		{
			if (n==2) 
				System.out.println(3);
			else
				System.out.println((n+1)*n/2);
		}
		else
		{
			if (n==1) 
				System.out.println(1);
			else
				System.out.println((n+2)*(n/2+1)-(n+1));
		}
	}
}
