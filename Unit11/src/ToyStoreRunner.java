//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStoreRunner
{
	public static void main( String args[] )
	{
		ToyStore toysrusBankrupt = new ToyStore("sorry bat sorry sorry sorry train train teddy teddy ball ball");
		System.out.println(toysrusBankrupt);
		toysrusBankrupt.sortToysByCount();
		System.out.println(toysrusBankrupt);
		System.out.println("max == " + toysrusBankrupt.getMostFrequentToy());
	}
}