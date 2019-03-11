//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Maron

import java.io.File; 
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.System.*;

public class WordRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("words.dat"));

		ArrayList<Word> words = new ArrayList<>();
		int size = file.nextInt();
		file.nextLine();
		while(file.hasNextLine()) {
			words.add(new Word(file.nextLine()));
		}
		words.sort((i, j) -> i.compareTo(j));
		System.out.println(Arrays.deepToString(words.toArray()));

	}
}