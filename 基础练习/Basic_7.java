package 基础练习;

public class Basic_7
{
	public static void main(String[] args) 
	{
		int q,w,e,flag;
		for (int i = 100; i < 1000; i++) 
		{
			q=i%10;
			w=i/10%10;
			e=i/100;
			flag=q*q*q+w*w*w+e*e*e;
			if (flag==i)
				System.out.println(i);
		}
	}
}
