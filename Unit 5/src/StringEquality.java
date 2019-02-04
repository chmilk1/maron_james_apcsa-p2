//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Maron
//Date - 2\1\19
//Class - APCSA
//Lab  - F101


import static java.lang.System.*;

public class StringEquality
{
	private String wordOne, wordTwo;

	public StringEquality()
	{
	}

	public StringEquality(String one, String two)
	{
		this.wordOne = one;
		this.wordTwo = two;
	}

	public void setWords(String one, String two)
	{
		this.wordOne = one;
		this.wordTwo = two;
	}

	public boolean checkEquality( )
	{
		return wordOne.equals(wordTwo);
	}

	public String toString()
	{
		return checkEquality() ? (wordOne + " has the same letters as " + wordTwo + "\n") : (wordOne + " does not have the same letters as " + wordTwo + "\n");
	}
}