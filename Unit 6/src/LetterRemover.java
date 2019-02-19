//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

import java.util.stream.Collectors;

public class LetterRemover
{
   private String sentence;
   private char lookFor;

	public LetterRemover()
	{
		this("hello world", '0');
	}
	
	public LetterRemover(String s, char c)
	{
		setRemover(s, c);
	}
	
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters()
	{
		return sentence.chars().mapToObj(c -> "" + ((char) c)).filter(c -> !c.equals("" + lookFor)).collect(Collectors.joining());
	}

	public String toString()
	{
		return sentence + " - letter to remove " + lookFor + "\n" + removeLetters();
	}
}