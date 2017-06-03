package chapter6;

import java.awt.RenderingHints;
import java.beans.FeatureDescriptor;
import java.util.LinkedList;
import java.util.Scanner;

public class pro6_9
{
	public static int W,W1,W2;
	public static Scanner cin=new Scanner(System.in);
	
	public static boolean solve()
	{
		int W1,D1,W2,D2;
		boolean b1=true;
		boolean b2=true;
		
		W1=cin.nextInt();
		D1=cin.nextInt();
		W2=cin.nextInt();
		D2=cin.nextInt();
		
		if (W1==0) b1=solve();
		if (W2==0) b2=solve();
		
		W=W1+W2;
		
		return b1 && b2 && (W1*D1==W2*D2);
	}
	
	
	public static void main(String[] args)
	{
		int T,W;
		Scanner cin=new Scanner(System.in);
		T=cin.nextInt();
		while(T-->0)
		{
			if(solve()) 
				System.out.println("YES");
			else
				System.out.println("NO");
			
			
		}
		
	}
}
