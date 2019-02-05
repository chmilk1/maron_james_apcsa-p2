//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Maron
//Date - 2/1/19
//Class - APCSA
//Lab  - F101

import static java.lang.System.*;

import java.util.Scanner;

public class WordRunner
{
	public static void main ( String[] args )
	{
		while(true) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter a string");
		printWord(new Word(s.nextLine()));
		System.out.println();
		}
	}
	
	public static void printWord(Word w) {
		System.out.println(w.getFirstChar());
		System.out.println(w.getLastChar());
		System.out.println(w.getBackWards());
		System.out.println(w.getWord());
	}
}