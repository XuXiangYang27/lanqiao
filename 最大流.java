package 最大流;
import java.util.LinkedList;
import java.util.Queue;
/**
 * @author 许湘扬
 * @email  547139255@qq.com
 * @detail 求有向图最大流
 */
public class 最大流 
{
	public static int v=6;
	/*
	 * 判断：是否可以在rGraph中找到一条从s到t的路径
	 * rGraph:残留网络
	 * s：源点
	 * t：终点
	 * path：路径
	 */
	
	//判断是否有增光路径
	public static Boolean hasPath(int rGraph[][],int s,int t,int path[])
	{
		boolean visited[]=new boolean[v];
		Queue<Integer>queue=new LinkedList<Integer>();
		queue.add(s);
		visited[s]=true;
		
		//标准的BFS算法
		while(queue.size()>0)//按层压入队列
		{
			int top=queue.poll();
			for (int i=0;i<v;i++)
			{
				if (!visited[i] && rGraph[top][i]>0)
				{
					queue.add(i);
					visited[i]=true;
					path[i]=top;//并将路径存入数组
					if (i==t) {
						return true;
					}
				}
			}
		}
		return false;
	}
	/*
	 *  graph 有向图的矩阵表示
	 *  s：源点
	 *  t：终点
	 */
	//计算最大流
	private static int maxFlow(int[][] graph,int s,int t)
	{
		int rGraph[][]=new int[v][v];
		//初始化残留网络
		for (int i=0;i<v;i++) 
			for (int j=0;j<v;j++)
				rGraph[i][j]=graph[i][j];
		
		int maxFlow=0;	
		int path[]=new int[v];
		while(hasPath(rGraph, s, t, path))
		{
			int min_flow=Integer.MAX_VALUE;
			
			//遍历路径中的每条边，找到最小的流量
			for (int v=t;v!=s;v=path[v])
			{
				int u=path[v];
				min_flow=Math.min(min_flow, rGraph[u][v]);
			}
			//更新残留网络
			for(int v=t;v!=s;v=path[v])
			{
				int u=path[v];
				rGraph[u][v]-=min_flow;
				rGraph[v][u]+=min_flow;
			}
			maxFlow+=min_flow;
		}
		return maxFlow;
	}
	
	public static void main(String[] args)
	{
		int graph[][]={
				{0,16,13,0,0,0},
				{0,0,10,12,0,0},
				{0,4,0,0,14,0},
				{0,0,9,0,0,20},
				{0,0,0,7,0,4},
				{0,0,0,0,0,0}};
		v=graph.length;
		int flow=maxFlow(graph, 0, 5);
		System.out.println("the maximum possible flow is:"+flow);
	}
}
