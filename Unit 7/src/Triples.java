
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
		int maxGCF = 1;
		for (int i = 1; i < MAX; i++) {
			if (a % i == 0 && b % i == 0 && c % i == 0) {
				maxGCF = i;
			}
		}
		return maxGCF;
	}

	public String toString() {
		String output = "";
		for (int a = 1; a < number; a++) {
			for (int b = 1; b < number; b++) {
				for (int c = 1; c < number; c++) {
					boolean testOne = Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2);
					boolean testTwo = (a % 2 == 1 && b % 2 == 0) || (a % 2 == 0 && b % 2 == 1) && c % 2 == 1;
					boolean testThree = greatestCommonFactor(a, b, c) == 1;
					boolean repeatTest = a < b && b < c;
					// System.out.println(testOne + " " + testTwo + " " + testThree);
					if (testOne && testTwo && testThree && repeatTest) {
						output = output + a + " " + b + " " + c + " \n";
					}
				}
			}
		}
		return output + "\n";
	}
}