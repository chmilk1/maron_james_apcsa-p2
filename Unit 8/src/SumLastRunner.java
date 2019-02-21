//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class SumLastRunner
{
	public static void main( String args[] )
	{
		int[] test1 = {-99,1,2,3,4,5,6,7,8,9,10,5};
		System.out.println(RaySumLast.go(test1));
		
		int[] test2 = {10,9,8,7,6,5,4,3,2,1,-99};
		System.out.println(RaySumLast.go(test2));
		
		int[] test3 = {10,20,30,40,50,-11818,40,30,20,10};
		System.out.println(RaySumLast.go(test3));
		
		int[] test45 = {32767};
		System.out.println(RaySumLast.go(test45));
		
		int[] test46 = {255,255};
		System.out.println(RaySumLast.go(test46));
		
		int[] test4 = {9,10,-88,100,-555,2};
		System.out.println(RaySumLast.go(test4));
	}
}