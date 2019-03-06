
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

import static java.lang.System.*;

public class ToyStore {
	private ArrayList<Toy> toyList;

	public ToyStore() {
	}

	public ToyStore(String toys) {
		loadToys(toys);
	}

	public void loadToys(String toys) {
		toyList = new ArrayList<>();
		HashMap<String, Integer> freq = new HashMap<>();
		for (String s : toys.split("\\s+")) {
			if(freq.containsKey(s)) {
				freq.put(s, new Integer(freq.get(s).intValue() + 1));
			} else {
				freq.put(s, new Integer(1));
			}
		}
		
		for(String s : freq.keySet()) {
			toyList.add(new Toy(s, freq.get(s)));
		}
	}

	public Toy getThatToy(String nm) {
		for (Toy t : toyList) {
			if(t.getName().equals(nm)) {
				return t;
			}
		}
		throw new RuntimeException("Toy Not Found");
	}
	
	//ill take my bonus points
	public String getMostFrequentToy() {
		int mostCount = Integer.MIN_VALUE;
		String mostString = "";
		for (Toy t : toyList) {
			if(t.getCount() > mostCount) {
				mostCount = t.getCount();
				mostString = t.getName();
			}
		}
		return mostString;
	}

	public void sortToysByCount() {
		toyList = (ArrayList<Toy>) toyList.stream().sorted(Comparator.comparing((Toy::getCount)))
				.collect(Collectors.toList());
	}

	public String toString() {
		String output = "[";
		for (Toy toy : toyList) {
			output = output + toy.getName() + " " + toy.getCount() + ", ";
		}
		return output.substring(0,output.length()-2) + "]";
	}
}