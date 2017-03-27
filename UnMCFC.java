package cycleMCMF;
import java.util.LinkedList;
import java.util.Scanner;

import org.junit.experimental.max.MaxCore;

/**
 * @author 许湘扬 2017-3-26
 * @邮箱   547139255@qq.com
 * @说明   17华为软件精英挑战赛
 */
public class UnMCFC 
{
	public static int MAX=1200;
	public static int fd=1;
	public static int INF=10000000;
	public static int n,m,n2;//顶点数，边数，消费节点个数
	public static Edge[] e=new Edge[MAX*20];//存储原图
	public static Edge[] e2=new Edge[MAX*20];//存储迭代图
	public static int[] dis=new int[MAX];//距离数组
	public static int[] first=new int[MAX];//
	public static int[] first2=new int[MAX];//
	public static int[] p=new int[MAX];//路径信息
	public static boolean[] vis=new boolean[MAX];
	public static int edgenum;//初始边数
	public static int edgenum2;//初始边数
	public static int f,d,cap;
	public static int c;//费用 ，f：流量
	public static int s,t;//终点 源点
	public static int[] path=new int[MAX];
	public static int[] xfId=new int[MAX];//消费节点ID
	public static int[] xfCon=new int[MAX];//消费节点直连的网络节点
	public static int[] xfXQ=new int[MAX];//消费节点的需求
	public static int price;//服务器价格
	public static int number=0;
	public static int MaxFlow=0;
	public static int MinCost=0;
	public static int[] m2m=new int[MAX];
	public static int index=0;//标记当前位置
	public static int[][] lujin=new int[MAX][MAX];//存储路径
	public static int addition=10;//增量
	
	public static boolean stop=false;
	
	public static void main(String[] args) throws InterruptedException 
	{
		init();
		s=n+1;
		t=n;
		long star = System.currentTimeMillis();
		int runingtime;
		while(true)//循环迭代
		{
			MCMF();
			//path(n+1,n);
	
			addition++;
			index++;
			if(stop)
				return ;
			long end = System.currentTimeMillis();
			runingtime=(int)(end-star)/1000;
			if(runingtime>79)
				return ;
			System.out.println("程序已运行："+runingtime+"秒");
		}
		//c+=price*7;
		//System.out.println("最大流量"+f+" 最小费用:"+c);
	}
	public static void init()
	{
		edgenum=0;
		edgenum2=0;
		
		for(int i=0;i<MAX;i++)//初始化first数组
			first[i]=-1;
		Scanner cin=new Scanner(System.in);
		n=cin.nextInt();
		m=cin.nextInt();
		n2=cin.nextInt();
		price=cin.nextInt();//服务器价钱
		
		int u,v,w,c;	
		for (int i=0;i<m;i++)//读取边权信息
		{
			u=cin.nextInt();
			v=cin.nextInt();
			c=cin.nextInt();
			w=cin.nextInt();	
			
			add(u, v, w, c);
			add(v, u, w, c);
		}
		
		int id,con,req;
		//读取消费节点信息
		for(int i=0;i<n2; i++)
		{
			id=cin.nextInt();
			con=cin.nextInt();
			req=cin.nextInt();
			xfId[i]=id;
			xfCon[i]=con;
			xfXQ[i]=req;
		}
		
		for (int i = 0; i<n2; i++)//目标流量
		{
			MaxFlow+=xfXQ[i];
		}
		MinCost=n2*price;//直接放在服务器的价格
		System.out.println("直接流量："+MaxFlow+" 直接花费："+MinCost);
		for (int i = 0; i <n2; i++)
			m2m[i]=xfXQ[i];
		int temp;
		for(int i=0;i<n2-1;i++)
			for(int j=0;j<n2-i-1;j++)
				if (m2m[j]>m2m[j+1]) 
				{
					temp=m2m[j];
					m2m[j]=m2m[j+1];
					m2m[j+1]=temp;
				}
		
		
		for (int i=0;i<n2; i++)
		{
			add(n,xfCon[i],0,xfXQ[i]);//添加超级汇点
			add(xfCon[i],n,0,xfXQ[i]);
//			add(n+1, xfCon[i],0,INF);
//			add(xfCon[i],n+1,0,INF);	
		}
		edgenum2=edgenum;//初始边+消费节点到超级汇点的边
		
		
	}
	public static void path(int s,int t)
	{
		int[][] result=new int[MAX][MAX];
		for(int i=0;i<n+2;i++)//加了两个节点
			for(int j=0;j<n+2;j++)//加了两个节点
				result[i][j]=0;
		for(int i=0;i<edgenum;i+=2)
			result[e2[i].u][e2[i].v]=e2[i].flow;
		int total=1;
		
		
		for(int num=1;f>0;num++ )//num:路径个数
		{
			for(int i=0;i<n+2;i++)//加了两个节点
			{	
				path[i]=-1; //初始化path数组
				vis[i]=false;//初始化vis数组
			}
			int u=s;
			int min=INF;
			while(true)//找到一条路径
			{
				int i;
				for( i=0;i<n+2;i++)//找到一个点  //加了两个节点
				{
					
					if(result[u][i]>0 && vis[i]==false)
					{
						path[u]=i;
						vis[i]=true;
						min=min<result[u][i]?min:result[u][i];
						break;
					}
				};
				if(i==t)
					break;
				u=i;
				}
				f-=min;
				//System.out.println("min:"+path[s]);
			
				for(int i=s;i!=t;i=path[i])//沿着路径减少流量
				{
					//System.out.println(i+"->"+path[i]);
					result[i][path[i]]-=min;
				}
				int rought=1;
				for (int i =path[s];i!=-1; i=path[i])//保存路径
				{
					//System.out.print(i+" ");
					lujin[num][rought]=i;
					rought++;
					if(path[i]==n)//当前i的下一跳节点是n,代表n是超级汇点
					{
						for(int j=0;j<n2;j++)//找到对应的 消费节点ID
						{
							if(i==xfCon[j])
							{
								//System.out.print(xfId[j]);
								lujin[num][rought]=xfId[j];
								rought++;
								break;//找到对应的消费节点ID，跳出循环
							}
						}
						break;//找到超级汇点，跳出循环
					}
				}
			
				lujin[num][rought]=min;;
				lujin[num][0]=rought;//保存这条边的条数
				lujin[0][0]=total;//保存路径数
				total++;
			//System.out.print(" "+min);
			//System.out.println();
//			for (int i =path[s];i!=-1; i=path[i])//输出路径
//			{
//				System.out.print(i+" ");
//				if(path[i]==n)
//				{
//					for(int j=0;j<n2;j++)
//					{
//						if(i==xfCon[j])
//						{
//							System.out.print(xfId[j]);
//							break;
//						}
//					}
//					break;
//				}
//			}System.out.print(" "+min);
//			System.out.println();
		}
	}
	public static void add(int u,int v,int w,int cap)
	{
		e[edgenum]=new Edge();
		e[edgenum].u=u;
		e[edgenum].v=v;
		e[edgenum].cost=w;
		e[edgenum].cap=cap;
		e[edgenum].flow=0;
		e[edgenum].next=first[u];
		first[u]=edgenum;
		edgenum++;
		
		e[edgenum]=new Edge();
		e[edgenum].u=v;
		e[edgenum].v=u;
		e[edgenum].cost=-w;
		e[edgenum].cap=0;
		e[edgenum].flow=0;
		e[edgenum].next=first[v];
		first[v]=edgenum;
		edgenum++;
	}
	public static void add2(int u,int v,int w,int cap)
	{
		e2[edgenum]=new Edge();
		e2[edgenum].u=u;
		e2[edgenum].v=v;
		e2[edgenum].cost=w;
		e2[edgenum].cap=cap;
		e2[edgenum].flow=0;
		e2[edgenum].next=first2[u];
		first2[u]=edgenum;
		edgenum++;
		
		e2[edgenum]=new Edge();
		e2[edgenum].u=v;
		e2[edgenum].v=u;
		e2[edgenum].cost=-w;
		e2[edgenum].cap=0;
		e2[edgenum].flow=0;
		e2[edgenum].next=first2[v];
		first2[v]=edgenum;
		edgenum++;
	}
	public static void  cycleInit()//每一次计算最小非用最大流时，初始化E2,
	{
		
		edgenum=edgenum2;
		for(int i=0;i<edgenum2;i++)//把e1复制到e2
		{
			e2[i]=new Edge();
			copy(e[i], e2[i]);//复制边
		}
		for(int i=0;i<MAX;i++)//初始化first数组
			first2[i]=first[i];
		
		
		number=0;
		
//		for (int i = 0; i <n2; i++)//测试：服务器节点直接放在消费节点
//		{
//			
//				add2(n+1, xfCon[i],0,INF);
//				add2(xfCon[i],n+1,0,INF);	
//				number++;
//		}
		//System.out.println(m2m[index]);
		for (int i = 0; i <n2; i++)//测试：服务器节点直接放在消费节点
		{	
			//if(xfXQ[i]>m2m[index])
			if(xfXQ[i]>addition)
			{
				add2(n+1, xfCon[i],0,INF);
				add2(xfCon[i],n+1,0,INF);	
				number++;
			}
		}
		//System.out.println("edgenum:"+edgenum+" edgenum2:"+edgenum2);
		//System.out.println(e);
	}
	public static void MCMF()
	{
		cycleInit();
		LinkedList<Integer> queue=new LinkedList<Integer>();
		c=f=0;
		
		while(true)//spaf算法求最短路
		{
			for(int i=0;i<n+2;i++)//初始化距离数组
				dis[i]=(i==s?0:INF);
			for(int i=0;i<n+2;i++)//初始化队列标记
				vis[i]=false;
			for(int i=0;i<n+2;i++)//初始化路径标记
				p[i]=-1;
			queue.push(s);
			
			while(!queue.isEmpty())
			{
				int u=queue.poll();
				vis[u]=false;
				for (int k=first2[u];k!=-1;k=e2[k].next)
				{
					//System.out.println(k);;
					int v = e2[k].v;
					if(e2[k].cap > e2[k].flow && dis[v] > dis[u] + e2[k].cost)  
					{  
						dis[v] = dis[u] + e2[k].cost;  
						p[v] = k;  
						if(!vis[v])  
						{  
							vis[v] = true;  
							queue.push(v);
						}  
					}
				}		
			}
			if(dis[t]== INF)  
	            break;  
	        int a = 999999999;
	        for(int u1=p[t];u1!=-1;u1=p[e2[u1].u])
	            a=(a<e2[u1].cap-e2[u1].flow?a:e2[u1].cap-e2[u1].flow); 
	       // System.out.println("a:"+a);
	        for(int u1=p[t];u1!=-1;u1=p[e2[u1].u]) 
	        {  
	            e2[u1].flow += a;  
	            e2[u1^1].flow -= a;  
	        }  
	        c += dis[t]*a;  
	        f += a;
		}
		c=c+price*number;
		if(f==MaxFlow && c<=MinCost)
		{
			MaxFlow=f;
			MinCost=c;
			System.out.println("最大流量"+f+" 最小费用:"+(c));
			path(s,t);
			
			//printPath();
		}
		else
		{
			System.out.println("程序退出，流量："+MaxFlow+" 花费："+MinCost);
			System.out.println("最大流量"+f+" 最小费用:"+(c+price*number));
			printPath();
			stop=true;
		}
		//System.out.println("最大流量"+f+" 最小费用:"+(c+price*number));
	}
	public static void printPath()
	{
		System.out.println("输出路径");
		for (int i=1;i<=lujin[0][0];i++) 
		{
			for (int j=1;j<=lujin[i][0]; j++)
			{
				System.out.print(lujin[i][j]+" ");
			}System.out.println();
		}
		
		//-----------------计算路径矩阵的所有流量
		int reCost=0;
		for (int i=1;i<=lujin[0][0]; i++)
		{
			int index=lujin[i][0];
			reCost+=lujin[i][index];
		}System.out.println("合计流量："+reCost);
		
	}
	public static  void copy(Edge e1,Edge e2)//edge对象复制值
	{
		e2.u=e1.u;
		e2.v=e1.v;
		e2.cost=e1.cost;
		e2.cap=e1.cap;
		e2.flow=e1.flow;
		e2.next=e1.next;
	}
}
class Edge
{
	public int u;
	public int v;
	public int cost;
	public int flow;
	public int cap;
	public int next;
}