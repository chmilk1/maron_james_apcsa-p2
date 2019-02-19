//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Scanner;
import static java.lang.System.*;

public class RPSRunner
{
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
		char response;
				
			String player = "";
			while(true) {
			out.print("type in your prompt [R,P,S] :: ");
			player = keyboard.next();
			System.out.println(new RockPaperScissors("" + player.toUpperCase().charAt(0)));	
			}
			
			
	}
}



