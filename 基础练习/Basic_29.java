package 基础练习;

import java.util.Scanner;
/**
 * @author 许湘扬
 * @email  547139255@qq.com
 * @detail   
 */
public class Basic_29
{
	public static void main(String[] args) 
	{
		Scanner cin=new Scanner(System.in);
		int[] a=new int[101];
		int[] b=new int[101];
		int[] result=new int[101];
		for (int i = 0; i <101; i++) 
		{
			a[i]=b[i]=result[i]=0;
		}
		String line1=cin.nextLine();
		String line2=cin.nextLine();
		
		for (int i = 0; i < line1.length(); i++) 
			a[i]=(int)line1.charAt(line1.length()-1-i)-48;	
		for (int i = 0; i < line2.length(); i++) 
			b[i]=(int)line2.charAt(line2.length()-1-i)-48;
		
		int max=line1.length()>line2.length()?line1.length():line2.length();
	
		int jinwei=0;
		int r=0;
		for (int i = 0; i < 101; i++)
		{
			result[i]=a[i]+b[i]+r;
			r=result[i]/10;
			result[i]%=10;
		}
		int flag=100;
		for (int i = 100; i>-1; i--) {
			if (result[i]!=0) {
				flag=i;
				break;
			}
		}
		for (int i = flag; i >-1; i--) {
			System.out.print(result[i]);
		}System.out.println();
		
	}
}
