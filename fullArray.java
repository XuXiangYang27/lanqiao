package chapter6;
import java.util.Scanner;

/**
 * @author 许湘扬
 * @email  547139255@qq.com
 * @detail 全排列
 */
public class fullArray 
{
	public static int lenth;//字符串长度
	public static int[] mark=new int[10];//标记数组
	public static char[] print=new char[10];//输出
	public static char[] str=new char[10];  //输入
	
	public static void dfs(int s)
	{
		if(s==lenth)
			System.out.println(print);
		
		for(int i=0;i<lenth;i++)
		{
			if(mark[i]==0)
			{
				mark[i]=1;
				print[s]=str[i];
				dfs(s+1);
				mark[i]=0;
			}
		}
	}
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		String string=cin.nextLine();//读取键盘输入的字符串
		lenth=string.length();//字符串的长度
		str=string.toCharArray();//把字符串转换成char数组
		
		dfs(0);
		
	}
}
