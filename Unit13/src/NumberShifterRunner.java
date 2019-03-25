//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifterRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner scan = new Scanner(System.in);
		int runs = scan.nextInt();
		Random rand = new Random();
		for(int i = 0; i < runs; i++) {
			int[] array = NumberShifter.makeLucky7Array(20*(i+1));
			System.out.println(Arrays.toString(array));
			System.out.println(Arrays.toString(NumberShifter.shiftEm(array)));
			System.out.println();
		}
	}
}