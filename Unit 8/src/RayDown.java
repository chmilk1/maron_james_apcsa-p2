//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Maron
//Date - 2/12/19

public class RayDown
{

	/*
	 * Simple solution:
	 * If statment returns false if their is an inrease
	 * returns false if no increase is found
	 */
	public static boolean go(int[] numArray)
	{
		for (int i = 1; i < numArray.length; i++) {
			if(numArray[i-1] <= numArray[i]) {
				return false;
			}
		}
		return true;
	}	
}