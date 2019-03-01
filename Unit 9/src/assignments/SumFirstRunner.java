package assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class SumFirstRunner
{
	public static void main( String args[] )
	{				
		//converting int[] -> ArrayList<Integer> instead of doing .add
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.addAll( Arrays.stream(new int[]{-99,1,2,3,4,5,6,7,8,9,10,5}).boxed().collect(Collectors.toList()));
		System.out.println(ListSumFirst.go(list1));
		
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.addAll( Arrays.stream(new int[]{10,9,8,7,6,5,4,3,2,1,-99}).boxed().collect(Collectors.toList()));
		System.out.println(ListSumFirst.go(list2));
		
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.addAll( Arrays.stream(new int[]{10,20,30,40,50,-11818,40,30,20,10}).boxed().collect(Collectors.toList()));
		System.out.println(ListSumFirst.go(list3));
		
		ArrayList<Integer> list4 = new ArrayList<>();
		list4.addAll( Arrays.stream(new int[]{32767}).boxed().collect(Collectors.toList()));
		System.out.println(ListSumFirst.go(list4));
		
		ArrayList<Integer> list5 = new ArrayList<>();
		list5.addAll( Arrays.stream(new int[]{255,255}).boxed().collect(Collectors.toList()));
		System.out.println(ListSumFirst.go(list5));
		
		ArrayList<Integer> list6 = new ArrayList<>();
		list6.addAll( Arrays.stream(new int[]{9,10,-88,100,-555,2}).boxed().collect(Collectors.toList()));
		
		System.out.println(ListSumFirst.go(list6));
	}
}