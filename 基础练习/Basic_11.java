package 基础练习;

import java.util.Scanner;

import org.omg.CORBA.INTERNAL;

public class Basic_11 
{
	public static void main(String[] args) 
	{
		Scanner cin=new Scanner(System.in);
		String date=cin.next();
		Long number=0L;
		for(int i=0;i<date.length();i++)
		{
			char c=date.charAt(i);
			switch(c)
			{
				case '0'	:number+=(long)(c-48)*(long)Math.pow(16,date.length()-i-1 );break;
				case '1'	:number+=(long)(c-48)*(long)Math.pow(16,date.length()-i-1 );break;
				case '2'	:number+=(long)(c-48)*(long)Math.pow(16,date.length()-i-1 );break;
				case '3'	:number+=(c-48)*(long)Math.pow(16,date.length()-i-1 );break;
				case '4'	:number+=(c-48)*(long)Math.pow(16,date.length()-i-1 );break;
				case '5'	:number+=(c-48)*(long)Math.pow(16,date.length()-i-1 );break;
				case '6'	:number+=(c-48)*(long)Math.pow(16,date.length()-i-1 );break;
				case '7'	:number+=(c-48)*(long)Math.pow(16,date.length()-i-1 );break;
				case '8'	:number+=(c-48)*(long)Math.pow(16,date.length()-i-1 );break;
				case '9'	:number+=(c-48)*(long)Math.pow(16,date.length()-i-1 );break;
				case 'A':number+=(c-55)*(long)Math.pow(16,date.length()-i-1 );break;
				case 'B':number+=(c-55)*(long)Math.pow(16,date.length()-i-1 );break;
				case 'C':number+=(c-55)*(long)Math.pow(16,date.length()-i-1 );break;
				case 'D':number+=(c-55)*(long)Math.pow(16,date.length()-i-1 );break;
				case 'E':number+=(c-55)*(long)Math.pow(16,date.length()-i-1 );break;
				case 'F':number+=(c-55)*(long)Math.pow(16,date.length()-i-1 );
				
			}
		}
		System.out.println(number);
	}
}
