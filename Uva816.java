package chapter6;

public class Uva816 
{
	public static final String dirs="NEWS";
	public static final String turns="FLR";

	//方向和转弯 转换函数
	public static int dir_id(char c)
	{
		return dirs.indexOf(c);
	}
	public static int turn_id(char c)
	{
		return turns.indexOf(c);
	}
	
	public static final  int[] dr={-1,0,1,0};
	public static final  int[] dc={0,1,0,-1};
	public static Node walk(Node u,int turn)
	{
		int dir=u.dir;
		if(turn==1)
			dir=(dir+3)%4;
		if(turn==1)
			dir=(dir+3)%4;
		return new Node(u.r+dr[dir], u.c+dc[dir], dir);
	}
}
class Node
{
	public int r,c,dir;

	public Node(int r, int c, int dir) {
		super();
		this.r = r;
		this.c = c;
		this.dir = dir;
	}
	
}