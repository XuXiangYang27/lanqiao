package 基础练习;
import java.util.Scanner;
/**
 * @author 许湘扬
 * @email  547139255@qq.com
 * @detail   
 */
public class Basic_14
{
	public static void main(String[] args) 
	{
		Scanner cin=new Scanner(System.in);
		String S1=cin.nextLine();
		String S2=cin.nextLine();
		if (S1.length()!=S2.length()) {
			System.out.println(1);
			return;
		}
		if (S1.equals(S2)) {
			System.out.println(2);
			return;
		}
		if (S1.length()==S2.length() && !S1.equals(S2) && S1.equalsIgnoreCase(S2)) {
			System.out.println(3);
			return;
		}
		if (S1.length()==S2.length() && !S1.equals(S2) && !S1.equalsIgnoreCase(S2)) {
			System.out.println(4);
			return;
		}
	}
}
