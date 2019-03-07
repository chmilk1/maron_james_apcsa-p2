//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

class Rational implements Comparable<Rational>
{
	//add two instance variables
	int numerator;
	int denoninator;
	//write two constructors
	public Rational() {
		this(1,1);
	}
	
	public Rational(int num, int deno) {
		setRational(num, deno);
	}

	//write a setRational method
	public void setRational(int num, int deno) {
		this.numerator = num;
		this.denoninator = deno;
	}

	//write  a set method for numerator and denominator

	
	public void add(Rational  other)
	{
		//num1/den1 + num2/den2 
		//new numerator = (num1 * den2 + num2 * den1)
		//new denominator = (den1 * den2)
		numerator = other.getNumerator() + numerator;
		denoninator = other.getDenoninator() + denoninator;
		
		reduce();
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenoninator() {
		return denoninator;
	}

	public void setDenoninator(int denoninator) {
		this.denoninator = denoninator;
	}

	private void reduce()
	{
		
	}

	private int gcd(int numOne, int numTwo)
	{


		return 1;
	}

	public Object clone ()
	{
		return "";
	}


	//ACCESSORS

	//write get methods for numerator and denominator
	
	
	public boolean equals( Object obj)
	{


		return false;
	}

	public int compareTo(Rational other)
	{


		return -1;
	}



	
	//write  toString() method
	
	
}