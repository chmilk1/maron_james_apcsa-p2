//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import static java.lang.System.*;

public class BiggestDouble
{
	private double one,two,three,four;

	//construtors and setters
	public BiggestDouble()
	{
		this(0,0,0,0);
	}

	public BiggestDouble(double a, double b, double c, double d)
	{
		setDoubles(a, b, c, d);
	}

	public void setDoubles(double a, double b, double c, double d)
	{
		this.one = a;
		this.two = b;
		this.three = c;
		this.four = d;
				
	}

	//gets the biggest double by itrating through a look and comparing each var to the other vars
	public double getBiggest()
	{
		double[] doubles = {one,two,three,four};
		double biggestDouble = Double.MIN_VALUE;
		
		for (int i = 0; i < doubles.length; i++) {
			boolean isBiggest = true;
			for (int j = 0; j < doubles.length; j++) {
				if(doubles[j] > doubles[i]) {
					isBiggest = false;
				}
			}
			if(isBiggest) {
				biggestDouble = doubles[i];
			}
		}
		return biggestDouble;
	}

	public String toString()
	{
	   return one + " " + two + " " + three + " " + four + " | " + getBiggest();
	}
}