package chapter6;

import java.util.Scanner;

public class TopologicalOrder
{
	public static int n,m,t;
	public static int[] topo=new int[100];
	public static int[][] graph=new int[101][101];
	public static int[] c=new int[101];
	
	public static boolean dfs(int u)
	{
		c[u]=-1;//正在访问中
		for(int i=1;i<=n;i++)
		{
			if(graph[u][i]>0)
			{
				if (c[i]==-1) //存在环，退出
					return false;
				
				if(c[i]==0 && !dfs(i) )//i没访问过且访问后发现有环，退出
					return false;
			}
		}
		c[u]=1;//u顶点访问完毕，修改状态，加入拓扑序列首部
		topo[--t]=u;
		return true;
	}
	public static boolean toposort()
	{
		t=n;
		for(int i=1;i<=n;i++)
			c[i]=0;
		
		for(int i=1;i<=n;i++)
			if(c[i]==0 )
				if(!dfs(i))
					return false;
		return true;
	}
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		
		while(true)
		{
			n=cin.nextInt();
			m=cin.nextInt();
			
			for(int i=0;i<=n;i++)
				for(int j=0;j<=n;j++)
					graph[i][j]=0;
			
			if (n==0 && m==0) {
				break;
			}
			int u,v;
			for(int i=0;i<m;i++)
			{
				u=cin.nextInt();
				v=cin.nextInt();
				graph[u][v]=1;
			}
			
			if (toposort()) 
				for(int i=0;i<n;i++)
					System.out.print(topo[i]+" ");
			System.out.println();
		}
	}
}
