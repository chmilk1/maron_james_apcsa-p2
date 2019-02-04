
//(c) A+ Computer Science
//www.apluscompsci.com
//www.apluscompsci.com
//Name - James Maron
//Date - 2\1\19
//Class - APCSA
//Lab  - F101

import static java.lang.System.*;

import java.util.Scanner;

public class WordsCompareRunner {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("enter a word");
			String s1 = scanner.nextLine();
			System.out.println("enter a word");
			String s2 = scanner.nextLine();
			
			WordsCompare wc = new WordsCompare(s1,s2);
			System.out.print(wc.toString());
			System.out.println("--==[]==--");
		}
	}
}