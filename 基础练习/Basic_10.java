package 基础练习;

import java.util.Scanner;

public class Basic_10
{
	public static void main(String[] args) 
	{
		Scanner cin=new Scanner(System.in);
		int a=cin.nextInt();
		StringBuilder ans=new StringBuilder();
		int remains=0;
		if (a==0) {
			System.out.println(a);
		}
		else
		{
			while(a!=0)
			{
				remains=a%16;
				a=a/16;
				switch(remains)
				{
					case 0:ans.append("0");break;
					case 1:ans.append("1");break;
					case 2:ans.append("2");break;
					case 3:ans.append("3");break;
					case 4:ans.append("4");break;
					case 5:ans.append("5");break;
					case 6:ans.append("6");break;
					case 7:ans.append("7");break;
					case 8:ans.append("8");break;
					case 9:ans.append("9");break;
					case 10:ans.append("A");break;
					case 11:ans.append("B");break;
					case 12:ans.append("C");break;
					case 13:ans.append("D");break;
					case 14:ans.append("E");break;
					case 15:ans.append("F");break;
				}
			}
			for (int i = ans.length()-1; i >=0; i--)
			{
				System.out.print(ans.charAt(i));
			}
		}
	}
}
