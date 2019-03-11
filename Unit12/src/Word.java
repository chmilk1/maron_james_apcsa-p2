//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Maron


public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s )
	{
		this.word = s;
	}

	public int compareTo( Word rhs )
	{		
		return Integer.compare(this.toString().length(), rhs.toString().length());
	}

	public String toString()
	{
		return word;
	}
}