
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSorter {
	// instance variables and other methods not shown

	private static int getNumDigits(int number) {
		int count = 0;
		while (number > 0) {
			number /= 10;
			count++;
		}
		return count;
	}

	public static int[] getSortedDigitArray(int number)
	{
		int[] sorted = new int[getNumDigits(number)];
		int index = 0;
		while(number > 0) {
			int digit = number % 10;
			boolean spotFound = false;
			int i = 0;
			while(!spotFound && i < sorted.length) {
				if(sorted[i] < digit) {
					spotFound = true;
					sorted = shiftList(i,digit,sorted);
				}
				i++;
			}
			number /= 10;
		}
		int[] reversed = new int[sorted.length];
		for(int i = 0; i < sorted.length; i++) {
			reversed[i] = sorted[sorted.length-i-1];
		}
		return reversed;
	}

	public static int[] shiftList(int spot, int var, int[] array) {
		for (int i = array.length - 2; i >= spot; i--) {
			array[i + 1] = array[i];
		}
		array[spot] = var;
		return array;
	}
}