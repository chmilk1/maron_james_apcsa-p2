
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

class Rational implements Comparable<Rational> {
	// add two instance variables
	private int numerator;
	private int denoninator;

	// write two constructors
	public Rational() {
		this(1, 1);
	}

	public Rational(int num, int deno) {
		setRational(num, deno);
	}

	// write a setRational method
	public void setRational(int num, int deno) {
		this.numerator = num;
		this.denoninator = deno;
		reduce();
	}

	// write a set method for numerator and denominator

	public void add(Rational other) {
		other.reduce();
		// num1/den1 + num2/den2
		// new numerator = (num1 * den2 + num2 * den1)
		// new denominator = (den1 * den2)
		numerator = getNumerator()*(other.getDenoninator()) + other.getNumerator()*(getDenoninator());
		denoninator = getDenoninator()*other.getDenoninator();
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

	private void reduce() {
		if(denoninator == 0) {
			throw new ArithmeticException("Divide by zero error");
		}
		if(denoninator < 0) {
			numerator = numerator * -1;
			denoninator = denoninator *-1;
		}
		
		for (int i = (numerator < denoninator ? numerator : denoninator); i > 1; i--) {
			if (numerator % i == 0 && denoninator % i == 0) {
				numerator = numerator / i;
				denoninator = denoninator / i;
				return;
			}
		}
	}

	private int gcd(int numOne, int numTwo) {
		return numOne*numTwo;
	}

	public Object clone() {
		return new Rational(numerator, denoninator);
	}

	public boolean equals(Object obj) {
		if (obj.getClass() != this.getClass()) {
			return false;
		} else {
			Rational rat = (Rational) obj;
			if (rat.getDenoninator() == this.getDenoninator() && rat.getNumerator() == this.getNumerator()) {
				return true;
			}
		}

		return false;
	}

	public int compareTo(Rational other) {
		double thisDecimal = (double)numerator/denoninator;
		double otherDecimal = (double)other.getNumerator()/other.getDenoninator();
		return Double.compare(thisDecimal, otherDecimal);
	}

	// write toString() method
	public String toString() {
		return numerator + "/" + denoninator + " " + ((float)numerator/(float)denoninator);
		
	}

}