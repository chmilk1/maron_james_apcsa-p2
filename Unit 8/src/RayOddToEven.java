//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Maron
//Date - 2/21/18

public class RayOddToEven
{
	public static int go(int[] ray)
	{
		int odd = -1;
		boolean oddFound = false;
		int even = -1;
		for (int i = 0; i < ray.length; i++) {
			if(ray[i]%2 == 1 && odd < 0) {
				odd = i;
				oddFound = true;
			} 
			if (ray[i]%2 == 0 && even < 0 && oddFound) {
				even = i;
			}
		}
		
		if(odd == -1 || even == -1) {
			return -1;
		}
		return Math.abs(odd - even);
	}
}