
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
		setAmount(Math.abs(amt));
	}

	public void setLetter(char c) {
		this.letter = c;
	}

	public void setAmount(int amt) {
		this.amount = amt;
	}

	public String toString() {
		//vars
		String output = "";
		char[] startingChars = getChars(letter, amount);
		String[][] boxes = new String[startingChars.length][];
		
		//populate lists
		for (int i = 0; i < boxes.length; i++) {
			String[] first = new String[boxes.length - i];
			for (int j = 0; j < first.length; j++) {
				String line = "";
				for (int x = 0; x < startingChars.length - i; x++) {
					line = line + startingChars[i];
				}
				first[j] = line;
			}
			boxes[i] = first;
		}
		
		//print lists
		for (int i = 0; i < boxes.length; i++) {
			for (int j = 0; j < boxes.length-i; j++) {
				output = output + boxes[j][i] + "  ";
			}
			output = output + "\n";
		}
		
		return output;
	}
	
	//Takes a capatal letter and gives back a list of letters
	public char[] getChars(char startL, int numOfletters) {
		char[] ret = new char[numOfletters];
		int start = startL;
		for (int i = 0; i < numOfletters; i++) {
			if(start + i > 90) start = 65-i;
			ret[i] = (char) (start+i);
		}
		
		return ret;
		
	}
}