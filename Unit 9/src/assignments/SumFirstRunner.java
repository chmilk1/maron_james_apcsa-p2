package assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class SumFirstRunner
{
	public static void main( String args[] )
	{				
		int[] test1 = {-99,1,2,3,4,5,6,7,8,9,10,5};
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.addAll((Collection<? extends Integer>) Arrays.stream(test1).mapToObj((int i) -> (Integer) i));
		System.out.println(ListSumFirst.go(list1));
		
		int[] test2 = {10,9,8,7,6,5,4,3,2,1,-99};
		System.out.println(ListSumFirst.go());
		
		int[] test3 = {10,20,30,40,50,-11818,40,30,20,10};
		System.out.println(ListSumFirst.go());
		
		int[] test45 = {32767};
		
		System.out.println(ListSumFirst.go());
		
		int[] test46 = {255,255};
		System.out.println(ListSumFirst.go());
		
		int[] test4 = {9,10,-88,100,-555,2};
		System.out.println(ListSumFirst.go());
	}
}