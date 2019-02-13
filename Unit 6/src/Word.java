//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Maron
//Date - 2/1/19
//Class - APCSA
//Lab  - F101
import static java.lang.System.*;

import java.util.Collections;
import java.util.function.Consumer;import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Word
{
	private String word;
	
	public Word()
	{
		word = " ";
	}

	public String getWord() {
		return word;
	}

	public Word(String s)
	{
		this.word = s;
	}

	public void setString(String s)
	{
		this.word = s;
	}

	public char getFirstChar()
	{
		return word.charAt(0);
	}

	public char getLastChar()
	{
		return word.charAt(word.length()-1);
	}

	//returns reversed string using stream
	public String getBackWards()
	{
		return word.chars().mapToObj(c -> "" + ((char) c)).sorted(Collections.reverseOrder()).collect(Collectors.joining());  
		
	}

 	public String toString()
 	{
 		return word + " " + getLastChar() + " " +getFirstChar() + " " + getBackWards();
	}
}