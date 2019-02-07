//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date - 
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class StringOddOrEven
{
	private String word;

	public StringOddOrEven()
	{
		this.word = "hello world";
	}

	public StringOddOrEven(String s)
	{
		this.word = s;
	}

	public void setString(String s)
	{
		this.word = s;
	}

 	public boolean isEven()
 	{
		return word.length() % 2 == 0 ? true: false;
	}

 	public String toString()
 	{
 		return word + " " + (isEven() ? "is even" : "is odd");
	}
}