//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Scanner;
import static java.lang.System.*;

public class RockPaperScissors
{
	private String playChoice;
	private String compChoice;

	
	//constructors
	public RockPaperScissors()
	{
		setPlayersChoice(intToWeapon((int) Math.random() *3));
		this.compChoice = intToWeapon((int) Math.random() *3);
	}

	public RockPaperScissors(String player)
	{
		setPlayersChoice(player);
		this.compChoice = intToWeapon((int) (Math.random() *3));
	}

	//setter (i refactored the name)
	public void setPlayersChoice(String player)
	{
		this.playChoice = player;
	}

	//determins winner and prints it out
	public String determineWinner()
	{
		compChoice = compChoice.toUpperCase().trim();
		playChoice = playChoice.toUpperCase().trim();
		String winner="error";
		if (playChoice.equals(compChoice)) {
			winner = "tie";
		}
		else if ("R".equals(playChoice) && "S".equals(compChoice) ||
			"P".equals(playChoice) && "R".equals(compChoice) ||
			"S".equals(playChoice) && "P".equals(compChoice)) {
			winner = "player";
		} else  {
			winner = "computer";
		}
		
		return winner;
	}
	
	//int to a choice method
	public String intToWeapon(int num) {
		return num > 0 ? (num == 1 ? "P" : "S") : "R";
		
	}

	public String toString()
	{
		String output= "player had " + playChoice + "\ncomputer had " + compChoice + "\n" + (determineWinner().equals("tie") ? "Tie!" : determineWinner() + " winns") + " " + getAction();
		return output;
	}

	private String getAction() {
		String winnerWeapon = "";
		String winner = determineWinner();
		if (winner.equals("player")) {
			winnerWeapon = playChoice;
		} else if(winner.equals("computer")) {
			winnerWeapon = compChoice;
		}
		String message = "<<";
		switch (winnerWeapon) {
		case "R":
			message = message + "rock breaks scissors>>";
			break;
		case "P":
			message = message + "paper suffocates rock>>";
			break;
		case "S":
			message = message + "scissors slash paper>>";
			break;
		default:
			message = message + "Draw>>";
			break;
		}
		return message;
	}
}