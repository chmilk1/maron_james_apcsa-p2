//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

import java.util.ArrayList;

public class Perfect
{
   private int number;

   //constructors and setters
   public Perfect(int number) {
		this.number = number;
   }
   public Perfect() {
		this.number = 0;
  }

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isPerfect()
	{
		ArrayList<Integer> factors = new ArrayList<>();
		int current = number;
		//adds all factors to a list
		for (int i = number-1; i > 1; i--) {
			if(current % i == 0) {
				factors.add(i);
				current = current / i;
			}
		}
		if(current > 1) {
			return false;
		} else {
			int sum = 0;
			//sums the factors
			for (int j = 0; j < factors.size(); j++) {
				sum += factors.get(j);
			}
			//checks the sum to the origonal
			if(sum+1 == number || sum == number) {
				return true;
			} else {
				return false;
			}
		}
		
	}

	@Override
	public String toString() {
		return number + "" + isPerfect();
		
	}
	
}