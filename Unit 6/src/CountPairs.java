//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Maron
//Date - 1/31
//Class - APCSA
//Lab  - F101
import static java.lang.System.*;

public class CountPairs
{
	//finds pairs by checking the next value to the current value
	public static int pairCounter( String str )
	{ 
		int count = 0;
		char[] strArray = str.toCharArray();
		for(int i = 0; i < strArray.length-2; i++) {
			if(strArray[i] == strArray[i+1]) {
				count++;
			}
		}
		
		return count;
	}
}