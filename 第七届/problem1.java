package 第七届;

import org.junit.Test;

public class problem1 

{
	public static void main(String[] args)
	{
		int sum=0;
		int current=1;
		for (int i =1; i <=100; i++)
		{
			sum+=current;
			current+=i+1;
		}
		System.out.println(sum);
	}
	
	@Test
	public void fun2()
	{
		
		for (int i = 1; i <=236; i++) 
		{
			int sum=0;
			for (int j = i; j <=236; j++)
			{
				sum+=j;
				if (sum==236) {
					System.out.println(i);
				}
				if (sum>236) {
					break;
				}
				
			}
		}
	}
}
