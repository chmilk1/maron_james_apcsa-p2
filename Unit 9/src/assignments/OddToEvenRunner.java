package assignments;
import assignments.ListOddToEven;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class OddToEvenRunner
{
	public static void main( String args[] )
	{
		//.box method converts int[] -> List<Integer> (was not aware of Arrays.asList())
		System.out.println(ListOddToEven.go(ListOddToEven.box(new int[] {7,1,5,3,11,5,6,7,8,9,10,12345,11})));
		System.out.println(ListOddToEven.go(ListOddToEven.box(new int[] {11,9,8,7,6,5,4,3,2,1,-99,7})));
		System.out.println(ListOddToEven.go(ListOddToEven.box(new int[] {10,20,30,40,5,41,31,20,11,7})));
		System.out.println(ListOddToEven.go(ListOddToEven.box(new int[] {32767,70,4,5,6,7})));
		System.out.println(ListOddToEven.go(ListOddToEven.box(new int[] {2,7,11,21,5,7})));
		System.out.println(ListOddToEven.go(ListOddToEven.box(new int[] {7,255,11,255,100,3,2})));
		System.out.println(ListOddToEven.go(ListOddToEven.box(new int[] {9,11,11,11,7,1000,3})));
		System.out.println(ListOddToEven.go(ListOddToEven.box(new int[] {7,7,7,11,2,7,7,11,11,2})));
		System.out.println(ListOddToEven.go(ListOddToEven.box(new int[] {2,4,6,8,8})));
	}
}