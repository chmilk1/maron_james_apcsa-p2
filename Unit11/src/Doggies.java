//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;

public class Doggies
{
	private Dog[] pups;

	public Doggies(int size)
	{
		//point pups at a new arry of Dog
		pups = new Dog[size];
	}
	
	public void set(int spot, int age, String name) throws Exception
	{
		if(spot > pups.length-1) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
		pups[spot] = new Dog(age, name);
		}
		//put a new Dog in the array at spot 
		//make sure spot is in bounds		
	}

	public String getNameOfOldest()
	{
		String nameOfOldest = "";
		int oldestAge = Integer.MIN_VALUE;
		for(Dog d : pups) {
			if(d.getAge() > oldestAge) {
				nameOfOldest = d.getName();
				oldestAge = d.getAge();
			}
		}
		return nameOfOldest;
	}

	public String getNameOfYoungest()
	{
		String nameOfYoungest = "";
		int youngestAge = Integer.MAX_VALUE;
		for(Dog d : pups) {
			if(d.getAge() < youngestAge) {
				nameOfYoungest = d.getName();
				youngestAge = d.getAge();
			}
		}
		return nameOfYoungest;
	}

	public String toString()
	{
		return ""+Arrays.toString(pups);
	}
}