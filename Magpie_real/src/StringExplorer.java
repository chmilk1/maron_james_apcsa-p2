/**
 * A program to allow students to try out different 
 * String methods. 
 * @author Laurie White
 * @version April 2012
 */
public class StringExplorer
{

	public static void main(String[] args)
	{
		String sample = "The quick brown fox jumped over the lazy dog.";
		
		//  Demonstrate the indexOf method.
		int position = sample.indexOf("quick");
		System.out.println ("sample.indexOf(\"quick\") = " + position);
		
		//  Demonstrate the toLowerCase method.
		String lowerCase = sample.toLowerCase();
		System.out.println ("sample.toLowerCase() = " + lowerCase);
		System.out.println ("After toLowerCase(), sample = " + sample);
		
		
		//assignments
		String test = "Computer Science is the best, the greatest, and the most wonderful subject to study!";
		int presistant = 0;
		while(test.length() > 0) {
		int pos = test.indexOf("the");
			if(pos != -1) {
				System.out.println("the is found at position " + (pos + presistant));
				presistant += 2;
				test = test.substring(pos+2, test.length());
			}
		}
	}

}
