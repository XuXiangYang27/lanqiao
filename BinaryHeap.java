package 第六章;

import javax.imageio.ImageTypeSpecifier;

public class BinaryHeap<T extends Comparable<? super T>>
{
	private int currentSize;
	private T[] array;
	
	//打印堆
	public void print()
	{
		for(int i=1;i<=currentSize;i++)
			System.out.print(array[i]+" ");
	}
	//插入 
	public  void insert(T x)
	{
		 int hole=++currentSize;
		 for(array[0]=x; x.compareTo(array[hole/2])<0 ;hole/=2)
			 array[hole]=array[hole/2];
		 array[hole]=x;
	}
	
	//删除     
	public T deleteMin()
	{
		if (currentSize<1) 
			return null;
		
		T minItem=array[1];
		array[1]=array[currentSize--];
		
		T temp=array[1];
		int hole,child;
		for(hole=1;hole*2<=currentSize;hole=child)
		{
			child=2*hole;
			if (child<currentSize && array[child+1].compareTo(array[child])<0)
				child++;
			if (array[child].compareTo(temp)<0) 
				array[hole]=array[child];
			else
				break;
		}
		array[hole]=temp;
		return minItem;
	}
	
	//构建堆
	public void biuldBinaryHeap(T[] items)
	{
		currentSize=items.length-1;
		int i=1;
		array=items;
		
		for(i=currentSize/2;i>0;i--)
		{
			int child,hole;
			T temp=array[i];
			for(hole=i;hole*2<=currentSize;hole=child)
			{
				child=2*hole;
				if(child<currentSize && array[child+1].compareTo(array[child])<0)
					child++;
				if(array[child].compareTo(temp)<0)
					array[hole]=array[child];
				else
					break;
			}
			array[hole]=temp;
		}
	}
	
	public static void main(String[] args) 
	{
		BinaryHeap<Integer> heap=new BinaryHeap<>();
		heap.biuldBinaryHeap(new Integer[]{0,79,66,43,83,30,87,38,55,91,72,49,9});
		heap.print();
	}
}
