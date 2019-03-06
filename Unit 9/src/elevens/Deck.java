package elevens;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {

	/**
	 * cards contains all the cards in the deck.
	 */
	private Card[] cards;

	/**
	 * size is the number of not-yet-dealt cards.
	 * Cards are dealt from the top (highest index) down.
	 * The next card to be dealt is at size - 1.
	 */
	private int size;


	/**
	 * Creates a new <code>Deck</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */
	public Deck(String[] ranks, String[] suits, int[] values) {
		/* *** IMPLEMENTED IN ACTIVITY 2 *** 2/22 */
		for (int i = 0; i < ranks.length; i++) {
			this.cards[i] = new Card(ranks[i], suits[i], values[i]);
		}
		shuffle();
	}
	
	public Deck(List<Card> cards) {
		this.cards = (Card[]) cards.toArray();
	}
	
	public Deck(Card[] cards) {
		this.cards = cards;
	}


	/**
	 * Determines if this deck is empty (no undealt cards).
	 * @return true if this deck is empty, false otherwise.
	 */
	public boolean isEmpty() {
		/* *** IMPLEMENTED IN ACTIVITY 2 *** 2/22 */
		ArrayList<Card> temp = new ArrayList<Card>();
		temp.addAll(Arrays.asList(cards));
		return temp.isEmpty();
	}

	/**
	 * Accesses the number of undealt cards in this deck.
	 * @return the number of undealt cards in this deck.
	 */
	public int size() {
		return cards.length;
		/* *** IMPLEMENTED IN ACTIVITY 2 *** 2/22 */
	}

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle() {
		Random rand = new Random();
		/* *** IMPLEMENTED IN ACTIVITY 4 *** 2/22 */
		ArrayList<Card> temp = new ArrayList<Card>();
		temp.addAll(Arrays.asList(cards));
		ArrayList<Card> finalList = new ArrayList<>();
		for (Card c : temp) {
			if(rand.nextBoolean()) {
				finalList.add(c);
			} else if(rand.nextBoolean()) {
				finalList.add(0, c);
			} else {
				finalList.add(finalList.size()/2, c);
			}
		}
		
		Card[] shuffledCards = new Card[finalList.size()];
		for (int i = 0; i < finalList.size(); i++) {
			shuffledCards[i] = finalList.get(i);
		}
		cards = shuffledCards;
		
	}

	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public Card deal() {
		if(cards.length > 1) {
			Card ret = cards[0];
			Card[] temp = new Card[cards.length-1];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = cards[i+1];
			}
			return ret;
		}
		return null;
		/* ***IMPLEMENTED IN ACTIVITY 2 *** 2/25 */
	}

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() {
		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards[k];
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.length - 1; k >= size; k--) {
			rtn = rtn + cards[k];
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cards.length) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}
