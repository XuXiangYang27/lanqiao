package 基础练习;



import java.util.Scanner;

public class Basic_17
{
	public static void main(String[] args)
	{
		int a,b;
		Scanner cin=new Scanner(System.in);
		a=cin.nextInt();
		b=cin.nextInt();
		long[][] mat=new long[30][30];
		long[][] mat2=new long[30][30];
		long[][] mat3=new long[30][30];
		for (int i = 0; i <a; i++) 
		{
			for (int j = 0; j <a; j++) 
			{
				mat2[i][j]=mat[i][j]=cin.nextInt();
			}
		}	
		int flag=1;
		if (b!=0)
		{
			for (int i = 1; i <b; i++)
			{
				if (i%2==1) 
				{
					for (int j = 0; j < a; j++) 
					{
						for (int k = 0; k < a; k++) 
						{
							long re=0;
							for (int l = 0; l < a; l++) 
							{
								re+=mat2[j][l]*mat[l][k];
							}
							mat3[j][k]=re;
						}
					}
					flag=1;
				}
				else
				{
					for (int j = 0; j < a; j++) 
					{
						for (int k = 0; k < a; k++) 
						{
							long re=0;
							for (int l = 0; l < a; l++) 
							{
								re+=mat3[j][l]*mat[l][k];
							}
							mat2[j][k]=re;
						}
					}
					flag=2;
				}
						
			}
			if (flag==1)
			{
				for (int i = 0; i <a; i++) 
				{
					for (int j = 0; j <a; j++) 
					{
						System.out.print(mat3[i][j]+" ");
					}System.out.println();
				}
			}
			if (flag==2)
			{
				for (int i = 0; i <a; i++) 
				{
					for (int j = 0; j <a; j++) 
					{
						System.out.print(mat2[i][j]+" ");
					}System.out.println();
				}
			}
		}
		else
		{
			for (int i = 0; i < a; i++)
			{
				for (int j = 0; j < a; j++)
				{
					if (i==j) {
						System.out.print(1+" ");
					}
					else
						System.out.print(0+" ");
				}System.out.println();
			}
		}
		
	}
}

