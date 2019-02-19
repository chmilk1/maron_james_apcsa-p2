
//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import static java.lang.System.*;

public class Triples {
	private int number;

	public Triples() {
		this(0);
	}

	public Triples(int num) {
		setNum(num);
	}

	public void setNum(int num) {
		this.number = num;
	}

	private int greatestCommonFactor(int a, int b, int c) {
		final int MAX = Math.min(a, Math.min(c, b));
		int max = 1;
		for (int i = 2; i < MAX; i++) {
			if (a % i == 0 && b % i == 0 && c % i == 0) {
				max = i;
			}
		}
		return max;
	}

	public String toString()
	{
		String output="";
		for(int a = 1; a < number; a++) {
			for(int b = 1; b < number; b++) {
				for(int c = 1; c < number; c++) {
					boolean testOne = Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2);
					boolean testTwo = (a % 2 == 1 && b % 2 == 0) || (a % 2 == 0 && b % 2 == 1) && c % 2 == 0;
					boolean testThree = greatestCommonFactor(a, b, c) <= 1;
					//System.out.println(testOne + " " + testTwo + " " + testThree);
					if(testOne && testTwo && testThree) {
						output = output + a + " " + b + " " + c + " \n";
					}
				}
			}
		}
		return output+"\n";
	}
}