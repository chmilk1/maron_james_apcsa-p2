//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Maron
//Date - 2/1/19
//Class - APCSA
//Lab  - F101

import static java.lang.System.*;

public class NumberVerify
{
	//checks if it is odd or even
	public static boolean isOdd( int num )
	{
		return Math.abs(num) % 2 == 1;
	}
	public static boolean isEven( int num )
	{
		return Math.abs(num) % 2 == 0;
	}	
}