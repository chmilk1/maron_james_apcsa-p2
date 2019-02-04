//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Maron
//Date - 2/1/19
//Class - APCSA
//Lab  - F101

import static java.lang.System.*;
import java.util.Scanner;

public class NumberVerifyRunner
{
	public static void main ( String[] args )
	{
		Scanner scanner = new Scanner(System.in);
		int notZero = 1;
		do {
			System.out.println("Enter A Whole Number(Zero quits program)");
			notZero = scanner.nextInt();
			if(notZero != 0) {
				System.out.println(notZero + " is odd :: " + NumberVerify.isOdd(notZero));
				System.out.println(notZero + " is even :: " + NumberVerify.isEven(notZero));
			}
		}while(notZero != 0);
		
	}
}