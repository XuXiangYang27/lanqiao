package chapter6;
import java.util.Scanner;
public class ADV_205 
{
	private static final int MAX=100000;
	private static int[] prime=new int[10000];
	private static int[] max=new int[MAX];
	private static int pSize=0;
	public static  void creatPrime(int n)
	{
		prime[pSize++]=2;
		for(int i=3;i<Math.sqrt(n);i++)
		{
			boolean flag=true;
			for(int j=2;j<=Math.sqrt(i)+1;j++)
			{
				if (i%j==0)
				{ 
					flag=false;
					break;
				}
			}
			if(flag)
				prime[pSize++]=i;
		}
	}
	
	public static int solve(int m,int n)
	{
		if(max[m]>=0)
			return max[m]+n;
		int t=0,MAX=0;
		for(int i=0;i<pSize;i++)
		{
			if(prime[i]>Math.sqrt(m))
				break;
			if( m%prime[i]==0)
			{
				t=solve(m-2*prime[i],prime[i]);
				if(t>MAX)
					MAX=t;
			}
		}
		max[m]=MAX;
		return MAX+n;
	}
	public static void main(String[] args) 
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		
		//初始化max数组
		for(int i=0;i<max.length;i++)
			max[i]=-1;
		max[0]=0;max[1]=0;max[2]=0;max[3]=0;
		
		//生成质数表
		creatPrime(n);
				
		System.out.println(solve(n, 0));
		
	}
}