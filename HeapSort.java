package 第七章;

public class HeapSort <T extends Comparable<? super T> > 
{
	/**
	 * used to deleteMax and buildHeap
	 * @param a 堆数组
	 * @param hole	向下渗透的index
	 * @param n 堆的逻辑长度
	 */
	private static <T extends Comparable<? super T>>
	void percDown(T[] a,int hole,int n)
	{
		int child;
		T temp;
		for(temp=a[hole];hole*2+1<n;hole=child)
		{
			child=hole*2+1;
			if(child+1<n && a[child].compareTo(a[child+1])<0)
				child++;
			if(temp.compareTo(a[child])<0)
				a[hole]=a[child];
			else
				break;
		}
		a[hole]=temp;
	}
	public static <T extends Comparable<? super T>>
	void heapSort(T[] a)
	{
		for(int i=a.length/2-1;i>0;i--)//构建堆
			percDown(a, i-1, a.length);
		
		for(int i=1;i<a.length;i++)
		{
			T temp=a[0];
			a[0]=a[a.length-i];
			a[a.length-i]=temp;
			percDown(a, 0, a.length-i);
		}
	}
	public static void main(String[] args) {
		Integer[] arr={26,53,97,41,58,59,31};
		heapSort(arr);
		for (Integer integer : arr) {
			System.out.print(integer+" ");
		}
	}
}
