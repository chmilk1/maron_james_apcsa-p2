//(c) A+ Computer Science
//www.apluscompsci.com
//www.apluscompsci.com
//Name - James Maron
//Date - 2\1\19
//Class - APCSA
//Lab  - F101

import static java.lang.System.*;

public class WordsCompare {
	private String wordOne, wordTwo;
	private int compare;

	public WordsCompare() {
		this.wordOne = "";
		this.wordTwo = "";
	}

	public WordsCompare(String one, String two) {
		setWords(one, two);
	}

	public void setWords(String one, String two) {
		this.wordOne = one;
		this.wordTwo = two;
	}

	public void compare() {
		compare = wordOne.compareTo(wordTwo);
	}

	public String toString() {
		compare();
		if (compare < 0) {
			return wordOne + " should be placed before " + wordTwo + "\n";
		} else {
			return wordOne + " should be placed after " + wordTwo + "\n";
		}
	}
}