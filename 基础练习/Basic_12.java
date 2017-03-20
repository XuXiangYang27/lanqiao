package 基础练习;
import java.util.Scanner;
/*
 * 思路先把十六进制转成二进制，然后二进制转成八进制
 */
public class Basic_12 
{
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		String date;
		for (int i=0; i<n ; i++)
		{
			date=cin.next();
			int lenth=date.length();		
			System.out.println(toE(toB(date)));			
		}
	}
	public static String toE(String date)//转成八进制字符串
	{
		/*
		 * 先把二进制 开头的长度不足三的部分单独拎出来转成二进制
		 */
		StringBuilder Edate=new StringBuilder();
		int length=date.length();
		int remain=length%3;
		String three;
		three=date.substring(0, remain);
		
		switch (three) 
		{
			case "01": Edate.append("1");break;
			case "1"  : Edate.append("1");break;		
			case "10": Edate.append("2");break;		
			case "11": Edate.append("3");break;
		}
		for (int i = remain; i <length-1; i+=3) 
		{
			three=date.substring(i, i+3);
			switch (three) 
			{
				case "000": Edate.append("0");break;
				case "001": Edate.append("1");break;
				case "010": Edate.append("2");break;
				case "011": Edate.append("3");break;
				case "100": Edate.append("4");break;
				case "101": Edate.append("5");break;
				case "110": Edate.append("6");break;
				case "111": Edate.append("7");
			}
		}
		/*
		 * 存在有且只有一个前置0的情况，所以要处理一下开头0
		 */
		if (Edate.charAt(0)=='0')
		{
			three=Edate.substring(1);
		}
		else
			three=Edate.toString();
		return three;
	}
	public static String toB(String date)//转成二进制字符串
	{
		StringBuilder Bdate=new StringBuilder();
		int length=date.length();
		for (int i = 0; i < length; i++) 
		{
			switch (date.charAt(i)) 
			{
				case '0': Bdate.append("0000"); break;
				case '1': Bdate.append("0001"); break;
				case '2': Bdate.append("0010"); break;
				case '3': Bdate.append("0011"); break;
				case '4': Bdate.append("0100"); break;
				case '5': Bdate.append("0101"); break;
				case '6': Bdate.append("0110"); break;
				case '7': Bdate.append("0111"); break;
				case '8': Bdate.append("1000"); break;
				case '9': Bdate.append("1001"); break;
				case 'A': Bdate.append("1010"); break;
				case 'B': Bdate.append("1011"); break;
				case 'C': Bdate.append("1100"); break;
				case 'D': Bdate.append("1101"); break;
				case 'E': Bdate.append("1110"); break;
				case 'F': Bdate.append("1111");
			}
		}
		return Bdate.toString();
	}
}
