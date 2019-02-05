//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Maron
//Date - 2/1/19
//Class - APCSA
//Lab  - F101

import static java.lang.System.*; 
import java.util.Scanner;

public class AddSubMult
{
	//does the opration based on the input
	public static double check( double a, double b )
	{
		if(a > b) {
			return a-b;
		}
		else if(b > a) {
		return b-a;
		}
		else {
			return a*b;
		}
	}
}