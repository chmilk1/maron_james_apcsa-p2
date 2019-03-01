package assignments;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.List;
import java.util.ArrayList;

public class ListDown
{
	//Lab Description didn't match sample output, this variable will change witch it follows
	final static boolean FOLLOW_OUTPUT = true;
	
	public static boolean go(List<Integer> numArray)
	{
		for (int i = 1; i < numArray.size(); i++) {
			if((numArray.get(i) >= numArray.get(i-1) && FOLLOW_OUTPUT) || 
					(numArray.get(i) <= numArray.get(i-1) && !FOLLOW_OUTPUT)) {
				return false;
			}
		}
		return true;
	}	
}