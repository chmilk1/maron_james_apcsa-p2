package assignments;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ListSumFirst
{
	public static int go(List<Integer> ray)
	{
		int x = ray.get(0);
		int y =  ray.stream().mapToInt(i -> i.intValue()).filter(i -> i > x).sum();
		return y != 0 ? y : -1;
	}
}