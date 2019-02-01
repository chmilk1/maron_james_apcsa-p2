//(c) A+ Computer Science 
//www.apluscompsci.com
//Name - James Maron
//Date - 2\1\19
//Class - APCSA
//Lab  - F101

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class Distance
{
	private int xOne,yOne,xTwo,yTwo;
	private double distance;

	public Distance()
	{
		this.xOne = 1;
		this.xTwo = 1;
		this.yOne = 1;
		this.yTwo = 1;
	}

	public Distance(int x1, int y1, int x2, int y2)
	{
		this.xOne = x1;
		this.xTwo = x2;
		this.yOne = y1;
		this.yTwo = y2;
	}

	public void setCoordinates(int x1, int y1, int x2, int y2)
	{
		this.xOne = x1;
		this.xTwo = x2;
		this.yOne = y1;
		this.yTwo = y2;
	}

	public void calcDistance()
	{
		distance = Math.sqrt(Math.pow(((double)xTwo-xOne), 2) + Math.pow(((double)yTwo-yOne), 2));
	}
	
	public double getDistance()
	{
		return distance;
	}
	
	public void print()
	{
		System.out.println(" x1 " + xOne + "\n x2 " + xTwo + "\n y1 " + yOne + "\n y1 " + yTwo );
	}
	
	//complete print or the toString

	public String toString()
	{
		return " x1 " + xOne + "\n x2 " + xTwo + "\n y1 " + yOne + "\n y1 " + yTwo + "\n dist " + distance;
	}
}