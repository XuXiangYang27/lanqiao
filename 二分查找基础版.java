package 算法1_1;

import java.util.concurrent.LinkedTransferQueue;

/*
 * 算法 P28
 */
public class 二分查找基础版 
{
	
	//二分查找递归版
	public static int recleB(int key,int[] a,int low,int hight)
	{
		if (low>hight) 
			return -1;
	
		int mid=low+(hight-low)/2;
		if (key>a[mid]) 
			return recleB(key, a, mid+1, hight);
		else if (key<a[mid]) 
			return recleB(key, a, low, mid-1);
		else 
			return mid;
		
	}
	
	//二分查找while版
	public static int BinarySearch(int key,int[] a)
	{
		int low,hight,mid;
		low=0;
		hight=a.length-1;
		
		while(low<=hight)
		{
			mid=low+(hight-low)/2;
			if (key<a[mid]) 
				hight=mid-1;
			else if(key>a[mid])
				low=mid+1;
			else 
				return mid;
		}
		return -1;
	}
	public static void main(String[] args)
	{
		int[] a={1,2,3,4,5,6,7,8,9,10};
		System.out.println(recleB(3, a, 0, a.length-1));
	}
}
