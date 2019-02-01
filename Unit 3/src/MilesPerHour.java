//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class MilesPerHour
{
	private int distance, hours, minutes;
	private double mph;

	public MilesPerHour()
	{
		setNums(0,0,0);
		mph=0.0;
	}

	public MilesPerHour(int dist, int hrs, int mins)
	{
		this.distance = dist;
		this.hours = hrs;
		this.minutes = mins;
	}

	public void setNums(int dist, int hrs, int mins)
	{
		this.distance = dist;
		this.hours = hrs;
		this.minutes = mins;
	}

	public void calcMPH()
	{
		mph = distance/(hours + ((double)minutes/60));
	}

	public void print()
	{
	}
	
	//create a print or toString or both
	
	public String toString()
	{
		return distance + "\n" + hours + "\n";
	}
}