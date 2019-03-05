//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class TriangleWordRunner
{
	public static void main( String args[] )
	{
		Scanner scan = new Scanner(System.in);
		do {
		System.out.print("Enter a word :: ");
		TriangleWord.printTriangle(scan.nextLine());
		System.out.println();
		System.out.print("Again? (y/n) : ");
		} while (scan.nextLine().equals("y"));
		
	}
}