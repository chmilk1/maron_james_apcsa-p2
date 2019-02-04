//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Maron
//Date - 2\1\19
//Class - APCSA
//Lab  - F101


import static java.lang.System.*;

import java.util.Scanner;

public class StringEqualityRunner
{
	public static void main( String args[] )
	{
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("enter a word");
			String s1 = scanner.nextLine();
			System.out.println("enter a word");
			String s2 = scanner.nextLine();
			
			StringEquality se = new StringEquality(s1,s2);
			System.out.print(se.toString());
			System.out.println("--==[]==--");
		}
	}
}