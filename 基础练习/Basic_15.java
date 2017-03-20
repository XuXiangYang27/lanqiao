package 基础练习;
import java.util.Scanner;
/**
 * @author 许湘扬
 * @email  547139255@qq.com
 * @detail   
 */
public class Basic_15 
{
	public static void main(String[] args) 
	{
		Scanner cin=new Scanner(System.in);
		int t=cin.nextInt();
		int h=t/3600;
		t%=3600;
		int s=t/60;
		t%=60;
		int m=t;
		System.out.println(h+":"+s+":"+m);
	}
}
