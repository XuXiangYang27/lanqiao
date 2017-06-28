package 第七章;

public class QuickSort<T extends Comparable<? super T>>
{
	public static <T extends Comparable<? super T>>
	void quickSort(T[] a)
	{
		quickSort(a, 0, a.length-1);
	}
	
	private static <T extends Comparable<? super T>>
	void swapReferences(T[] a,int one,int two)
	{
		T temp=a[one];
		a[one]=a[two];
		a[two]=temp;
	}
	
	private static <T extends Comparable<? super T>>
	T median(T[] a,int left,int right)
	{
		int center=(left+right)/2;
		if (a[center].compareTo(a[left])<0)
			swapReferences(a, center, left);
		if (a[right].compareTo(a[left])<0)
			swapReferences(a, right, left);
		if (a[right].compareTo(a[center])<0)
			swapReferences(a, right, center);	
		
		swapReferences(a, center, right);
		return a[right];
	}
	
	private static <T extends Comparable<? super T>>
	void quickSort(T[] a,int left,int right)
	{
		if (left>=right) 
			return;
		T pivot=a[left];
		swapReferences(a, left, right);
		int i=left;
		int j=right-1;
		for(;;)
		{
			while(a[i].compareTo(pivot)<0){i++;}
			while(a[j].compareTo(pivot)>0){j--;}
			if (i<j) 
				swapReferences(a, i, j);
			else
				break;
		}
		swapReferences(a, i, right);
		quickSort(a, left, i-1);
		quickSort(a,i+1,right);
	}
	
	public static void main(String[] args) {
		Integer[] a= new Integer[]{31,67,43,90,32,13,45,99,0,5};
		quickSort(a);
		
		for (Integer integer : a) {
			System.out.print(integer+" ");
		}
	}
}
