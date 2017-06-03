package 第四章;
import org.omg.CORBA.PRIVATE_MEMBER;
import 第三章.BlanceChar;
public class AvlTree<T extends Comparable<? super T>> 
{
	private static class AvlNode<T>
	{
		T element;
		AvlNode<T> left;
		AvlNode<T> right;
		int height;
		public AvlNode(T element) 
		{ 
			this(element,null,null);
		}
		public AvlNode(T element, AvlNode<T> left, AvlNode<T> right)
		{
			super();
			this.element = element;
			this.left = left;
			this.right = right;
			this.height =0;
		}
	}
	private int height(AvlNode<T> root)
	{
		return root==null? -1:root.height;
	}
	//左单旋
	private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2)
	{
		AvlNode<T> k1=k2.left;
		k2.left=k1.right;
		k1.right=k2;
		k2.height=Math.max(height(k2.left),height(k2.right))+1;
		k1.height=Math.max(height(k1.left),height(k1.right))+1;
		return k1;
	}
	//右单旋
	private AvlNode<T> rotateWithRightChild(AvlNode<T> k2)
	{
		AvlNode<T> k1=k2.right;
		k2.right=k1.left;
		k1.left=k2;
		k2.height=Math.max(height(k2.left), height(k2.right));
		k1.height=Math.max(height(k2), height(k1.right))+1;
		return k1;
	}
	//左右双旋
	private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3)
	{
		k3.left=rotateWithRightChild(k3.left	);
		return rotateWithLeftChild(k3);
	}
	//右左双旋
	private AvlNode<T> doubleWithRightChild(AvlNode<T> k3)
	{
		k3.left=rotateWithLeftChild(k3.left	);
		return rotateWithRightChild(k3);
	}
	private AvlNode<T> insert(T x,AvlNode<T> root)
	{
		if (root==null)
			return new AvlNode<T>(x);
		int compareResult=x.compareTo(root.element);
		if(compareResult<0)
			return insert(x, root.left);
		else if(compareResult>0)
			return insert(x, root.right);
		else 
			;//重复的数据，不做操作
		return balance(root);
	}
	private static final int ALLOWED_IMBALANCE=1;
	private AvlNode<T> balance(AvlNode<T> root)
	{
		if (root==null) 
			return root;
		if (height(root.left)-height(root.right)>ALLOWED_IMBALANCE)
			if(height(root.left.left)>=height(root.left.right))
				root=rotateWithLeftChild(root);
			else 
				root=doubleWithLeftChild(root);
		else 
		if (height(root.right)-height(root.left)>ALLOWED_IMBALANCE)
			if(height(root.right.right)>=height(root.right.left))
				root=rotateWithRightChild(root);
			else 
				root=doubleWithRightChild(root);
		root.height=Math.max(height(root.left), height(root.right))+1;
		return root;
			
	}
}
