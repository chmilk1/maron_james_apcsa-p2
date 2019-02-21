import java.util.Arrays;
import java.util.stream.IntStream;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Maron
//Date -2/21/18

public class RaySumLast
{
	//using the filter function on streams to get everything bigger, then summing the array
	public static int go(int[] ray)
	{
		int x = ray[ray.length-1];
		int y = Arrays.stream(ray).filter(i -> i > x).sum();
		return y != 0 ? y : -1;
	}
}