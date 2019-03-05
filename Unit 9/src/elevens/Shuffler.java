package elevens;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 4;

	/**
	 * The number of values to shuffle.
	 */
	private static final int VALUE_COUNT = 12;

	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = new int[VALUE_COUNT];
		for (int i = 0; i < values1.length; i++) {
			values1[i] = i;
			}
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			values1 = perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k] + ", ");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = new int[VALUE_COUNT];
		for (int i = 0; i < values2.length; i++) {
			values2[i] = i;
			}
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			values2 = selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k] + ", ");
			}
			System.out.println();
		}
		System.out.println();
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static int[] perfectShuffle(int[] values) {
		ArrayList<Integer> list = (ArrayList<Integer>) assignments.ListOddToEven.box(values);
		List<Integer> l1 = list.subList(0, list.size()/2);
		List<Integer> l2 = list.subList(list.size()/2, list.size());
		
		ArrayList<Integer> finalList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			finalList.add(i % 2 == 0 ? l1.get(i/2) : l2.get(i/2));
		}
		
		return finalList.stream().mapToInt(i -> i.intValue()).toArray();
		
		/* *** IMPLEMENTED IN ACTIVITY 3 2/28? & 3/1 *** */
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static int[] selectionShuffle(int[] values) {
		/* *** IMPLEMENTED IN ACTIVITY 3 *** 3/1 */
		List<Integer> inital = assignments.ListOddToEven.box(values);
		List<Integer> selected = new ArrayList<>();
		Random rand = new Random();
		while(!inital.isEmpty()) {
			int index = rand.nextInt(inital.size());
			selected.add(inital.get(index));
			inital.remove(index);
		}
		return selected.stream().mapToInt(i -> i.intValue()).toArray();
	}
}
