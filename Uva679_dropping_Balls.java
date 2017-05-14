

import java.security.KeyStore.PrivateKeyEntry;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		int  nodeNum=1<<20;
		int [] tree=new int[1<<20]; 
		
		
		
		Scanner cin=new Scanner(System.in);
		int d,max;
		
		while(true)
		{
			if (cin.hasNextLine())//读取 深度和球数
			{
				d=cin.nextInt();
				max=cin.nextInt();
			}
			else
				return ;
			
			
			
			int maxNode=(1<<d)-1;
			for (int i = 0; i < max; i++) //初始化开关
				tree[i]=0;
			
			int k=1;
			for(int i=1;i<=max;i++)//挨个放球
			{
				k=1;
				while(true)
				{
					if (tree[k]==1) 
						tree[k]=0;
					else
						tree[k]=1;
					
					k= tree[k]==1? 2*k:2*k+1;
					if (k>maxNode) 
					{
						break;
					}
				}
				
			}System.out.println(k/2);	
		}
		
		
		
		
	}
}
