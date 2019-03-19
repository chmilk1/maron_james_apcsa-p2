//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifter
{
	public static int[] makeLucky7Array( int size)
	{
		Random rand = new Random();
		int[] fin = new int[size];
		for(int i = 0; i < size; i++)
			fin[i] = rand.nextInt(11);
		return fin;
	}
	public static int[] shiftEm(int[] array)
	{
		int[] fin = new int[array.length];
		for(int i = 0; i < fin.length; i++)
			fin[i] = 7;
		
		int finIndex = array.length-1;
		for(int i = array.length-1; i >= 0; i--) {
			if(array[i] != 7) {
				fin[finIndex] = array[i];
				finIndex--;
			}
		}
		return fin;
	}
}