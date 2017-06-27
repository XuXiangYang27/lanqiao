package 第七章;

import javax.lang.model.util.AbstractAnnotationValueVisitor6;

public class InsertSort 
{
	//简单插入排序
	public static void  insertSort(int[] arr)
	{
		int i;
		for(int p=1;p<arr.length;p++)
		{	
			int temp=arr[p];
			for( i=p;i>0 && arr[i]<arr[i-1];i--)
				arr[i]=arr[i-1];
			arr[i]=temp;
		}
	}
	
	//希尔排序
	public static void shellSort(int[] a)
	{
		int i;
		for(int gap=a.length/2;gap>0;gap/=2)
		{
			for(int j=gap;j<a.length;j++)
			{
				int temp=a[j];
				for(i=j;i>=gap && temp<a[i-gap];i-=gap)
					a[i]=a[i-gap];
				a[i]=temp;
			}
		}
	}
	
	//冒泡排序
	public static void  bubbleSort(int[] a)
	{
		boolean flag=false;
		int temp;
		for(int i=1;i<a.length;i++)
		{
			for(int j=0;j<a.length-i;j++)
			{
				if (a[j]>a[j+1]) 
				{
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					flag=true;
				}
			}
			if(flag)
				break;
		}
	}
	public static void main(String[] args)
	{
		int[] a={34,8,64,51,32,21};
		int[] b={5,5,4,4,3,3,2,2,1,1};
		//insertSort(b);
		//shellSort(a);
		bubbleSort(a);
		for (int i : a) 
			System.out.print(i+" ");
	}
}
