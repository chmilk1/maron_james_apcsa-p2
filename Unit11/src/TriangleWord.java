//(c) A+ Computer Science
//www.apluscompsci.com
//Name -


public class TriangleWord
{
	//instance variables and constructors could be present, but are not necessary
		
	public static void printTriangle(String word)
	{
		for (int i = 1; i < word.length()+1; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(word.substring(0,i));
			}
			System.out.println();
		}
	}
}