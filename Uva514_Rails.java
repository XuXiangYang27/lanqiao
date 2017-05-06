package chapter6;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 许湘扬
 * @email  547139255@qq.com
 * @detail Uva514 Rails(铁轨) 
 */
public class Uva514_Rails 
{
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		int[	]  result=new int[1000];
		int n=-1;
		while(  (n=cin.nextInt())!=-1 && n!=0)
		{
			//----------------给B、A区赋予初值-------------------
			
			while( (result[0]=cin.nextInt())!=-1 && result[0]!=0 )
			{
				for (int i = 1; i < n; i++) 
				{
					result[i]=cin.nextInt();
				}
				
				boolean flag=true;
				int index=1;
				//-------------------------------------------
				LinkedList<Integer> stack=new LinkedList<Integer>();
				
				for (int i = 0; i < n; i++) 
				{
					int a=result[i];
					
					while(index<=n)//依次把比当前数字小的数字压入栈中
					{
						stack.push(index);
						
						if (index==a)
						{
							index++;
							break;
						}
						index++;		
					}
					
					//取出栈顶元素与当前结果数字对比，不同则是错误的序列
					if (a!=stack.pop())
					{
						System.out.println("No");
						flag=false;
						break;
					}
				}
				if (flag) 
					System.out.println("Yes");
				
				result[0]=-1;
			}
			n=-1;
		}
	}
}
