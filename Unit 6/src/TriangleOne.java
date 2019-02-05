//(c) A+ Computer Science
//www.apluscompsci.com
//Name

import static java.lang.System.*;

public class TriangleOne
{
	private String word;

	//basic construstors and setters
	public TriangleOne()
	{
		this.word="";
	}

	public TriangleOne(String s)
	{
		this.word = s;
	}

	public void setWord(String s)
	{
		this.word = s;
	}

	//prints the triangle shape
	public void print( )
	{
		for (int i = word.length(); i > 0; i--) {
			System.out.println(word.substring(0, i));
		}
		System.out.println();
	}
}