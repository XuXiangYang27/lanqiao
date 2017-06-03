package chapter6;

import java.beans.FeatureDescriptor;
import java.util.LinkedList;
import java.util.Scanner;

public class pro6_2
{
	public static void main(String[] args)
	{
		String line;
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextLine())
		{
			line=cin.nextLine();
			LinkedList<Character> list=new LinkedList<>();
			int index=0;
			int flag=0;
			for (int i = 0; i <line.length(); i++)
			{
				if (line.charAt(i)=='[')
				{
					index=0;continue;
				}
				else if (line.charAt(i)==']') {
					index=list.size();continue;
				}
				
				list.add(index, line.charAt(i));
				index++;
			}
			for (Character character : list) {
				System.out.print(character);
			}System.out.println();
		}
		
	}
}
