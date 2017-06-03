package chapter6;

import java.util.LinkedList;
import java.util.Scanner;

public class pro6_4
{
	public static void main(String[] args)
	{
		int n;
		int[] target=new int[1000];
		LinkedList<Integer> stack=new LinkedList<>();
		
		
		Scanner cin=new Scanner(System.in);
		n=cin.nextInt();
		
		for (int i = 1; i <=n; i++) {
			target[i]=cin.nextInt();
		}
		int ok=1;
		int a=1,b=1;
		while(b<=n)
		{
			if (target[b]==a) {
				a++;b++;
			}
			else if (!stack.isEmpty() && stack.getFirst().equals(target[b])) {
				stack.pop();b++;
			}
			else if (a<=n) {
				stack.push(a++);
			}
			else {
				ok=0;break;
			}
			
		}
		
	}
}
