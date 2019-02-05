//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Maron
//Date - 1/31
//Class - APCSA
//Lab  - F101


public class FirstLastVowel
{
	//checks if the last or first char in a string is a vowel
   public static String go( String a )
	{
		if("aeiouAEIOU".contains("" + a.charAt(0)) || "aeiouAEIOU".contains("" + a.charAt(a.length()-1))) {
			return "yes";
		}
		return "no";
	}
}