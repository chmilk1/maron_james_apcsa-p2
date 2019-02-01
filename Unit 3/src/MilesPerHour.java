//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Maron
//Date - 2/1/19
//Class - APCSA
//Lab  - F101

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
		System.out.println("distance " + distance + "\n hours " + hours + "\n minutes " + minutes + "\n mph " + Math.round(mph));
	}
	
	//create a print or toString or both
	
	public String toString()
	{
		return " distance " + distance + "\n hours " + hours + "\n minutes " + minutes + "\n mph " + Math.round(mph);
	}
}