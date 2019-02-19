
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class TriangleFive {
	private char letter;
	private int amount;

	public TriangleFive() {
		this('C', 0);
	}

	public TriangleFive(char c, int amt) {
		setLetter(c);
		setAmount(amt);
	}

	public void setLetter(char c) {
		this.letter = c;
	}

	public void setAmount(int amt) {
		this.amount = amt;
	}

	public String toString() {
		String output = "";
		char[] startingChars = getChars(letter, amount);
		String[][] boxes = new String[startingChars.length][];
		
		for (int i = 0; i < boxes.length; i++) {
			String[] first = new String[startingChars.length - i];
			for (int j = 0; j < first.length - i; j++) {
				String line = "";
				for (int x = 0; x < startingChars.length - i; x++) {
					line = line + startingChars[i];
				}
				first[j] = line;
			}
			boxes[i] = first;
		}
		
		
		return output;
	}
	
	//Takes a capatal letter and gives back a list of letters
	public char[] getChars(char startL, int numOfletters) {
		char[] ret = new char[numOfletters];
		int iSetback = 0;
		for (int i = 0; i < amount; i++) {
			if(startL + i < 91) {
			ret[i] = (char) (startL + i);
			} else if(startL + i == 91) {
				ret[i] = 'A';
			} else {
				ret[i] = (char) (ret[i-1] + 1);
			}
		}
		return ret;
		
	}
}