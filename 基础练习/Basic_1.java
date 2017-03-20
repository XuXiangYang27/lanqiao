package 基础练习;

import java.util.Scanner;
public class Basic_1
{
	public static void main(String[] args) 
	{
		Scanner cin=new Scanner(System.in);
		int y=cin.nextInt();
		
		if (y%400==0 || (y%4==0 && y%100!=0))
			System.out.println("yes");
		else
			System.out.println("no");
	}
}
