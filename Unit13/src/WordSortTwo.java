//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class WordSortTwo
{
	private String[] wordRay;

	public WordSortTwo(String sentence)
	{
		wordRay = sentence.split("\\s+");
	}

	public void sort()
	{
		Object[] sortedWordRay = Arrays.stream(wordRay).sorted().toArray();
		for(int i = 0; i < sortedWordRay.length; i++) {
			wordRay[i] = (String) sortedWordRay[i];
		}
	}

	public String toString()
	{
		String output="";
		for(String s : wordRay)
			output += s + "\n";
		return output+"\n";
	}
}