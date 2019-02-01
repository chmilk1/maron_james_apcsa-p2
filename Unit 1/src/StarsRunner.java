//© A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class StarsRunner
{
   public static void main(String args[])
   {
      //instantiate a StarsAndStripes object
      StarsAndStripes flag = new StarsAndStripes();
      //call the methods needed to make the patterns on the word document
      for (int i = 0; i < 6; i++) {
    	  flag.printASmallBox();
    	  flag.printTwentyDashes();
          flag.printTwentyStars();
          flag.printTwentyDashes();
          flag.printTwentyStars();
          flag.printTwentyDashes();
          flag.printTwentyStars();
          
          flag.printTwoBlankLines();
          flag.printABigBox();
          
          "".length();
	}
   }
}