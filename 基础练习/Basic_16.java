package 基础练习;

import java.util.Scanner;

public class Basic_16
{
	public static int[] zhishu=new int[10000];
	{
		zhishu[0]=2;
	}
	//
	public static int index=0;
	public static void main(String[] args) 
	{
		Scanner cin=new Scanner(System.in);
		int a,b;
		a=cin.nextInt();
		b=cin.nextInt();
		
		for (int i = 2; i <=b; i++) 
		{
			if (isZhiShu(i)) {
				index+=1;
				zhishu[index]=i;
			}
		}
		
		for (int i = a; i <=b; i++) 
		{
			double result=i;
			double k=2;
			System.out.print(i+"=");
			double old=2;
			if (isZhiShu(i)) {
				System.out.println(i);
			}
			else
			for (int j=0;j<=index;) 
			{
				k=zhishu[j];
				
				if (result%k==0) //如果对这个质数能整除
				{
					if (result/k==1) //这个是为了判断*号输出的
					{
						System.out.println((int)k);
						break;
					}
					else
						System.out.print((int)k+"*");
					result=result/k;
				}
				else
					j++;
			
			}
		}
	}
	public static boolean isZhiShu(double n)//判断是不是质数
	{
		Boolean flag=true;
		if (n==2) 
			flag= true ;
		double end=Math.sqrt(n);
		for (double i = 2; i<=end; i++)
		{
			if (n%i==0)
			{
				flag=false;
				break;
			}
		}
		return flag;
	}
}
