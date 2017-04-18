package 第三章;

/**
 * @author 许湘扬
 * @email  547139255@qq.com
 * @detail  栈的小应用  平衡符号（P59）
 */
public class BlanceChar
{
	public boolean isKuohao(char c)//判断字符是否是括号
	{
		if (c=='[' || c=='{' || c=='(' || c==']' || c=='}' || c==')')
			return true;
		else
			return false;
	}
	public boolean isLeftKuohao(char c)//判断是否是左括号
	{
		if (c=='[' || c=='{' || c=='(' )
			return true;
		else
			return false;
	}
	public boolean isMatch(char a,char b)//判断a、b是否是匹配的括号
	{
		if (a=='(' && b==')') 
			return true;
		if (a=='[' && b==']') 
			return true;
		if (a=='{' && b=='}') 
			return true;
		return false;
	}
	public boolean isLegal(String content)//判断字符串中的括号是否合法
	{
		MyLinkedStack<Character> chars=new MyLinkedStack<>();
		for(int i=0;i<content.length();i++)
		{
			char c=content.charAt(i);
			if (isKuohao(c)) //如果字符是括号
			{
				if (isLeftKuohao(c))//如果是左括号：压入栈
				{
					chars.push(c);
				}
				else//如果是右括号，则与栈顶元素进行对比，看是否匹配
				{
					char leftC=chars.pop();
					if (!isMatch(leftC, c)) {
						return false;
					}
				}
			}
		}
		if (chars.isEmpty()) 
			return true;
		else
			return false;
	}
	public static void main(String[] args)
	{
		BlanceChar test=new BlanceChar();
		System.out.println(test.isLegal("dasdsa[(dasd}]"));;
	}
}
