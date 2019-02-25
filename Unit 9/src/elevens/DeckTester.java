package elevens;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card q = new Card("Queen", "Hearts", 12);
		Card a = new Card("Ace", "Spades", 14);
		Card twoh = new Card("2", "Hearts", 2);
		Deck getDecked = new Deck(new Card[]{q,a,twoh});
		System.out.println(getDecked);
		getDecked.shuffle();
		System.out.println(getDecked);
		System.out.println(getDecked.deal());
		System.out.println(getDecked);
		/* *** IMPLEMENTED IN ACTIVITY 2 *** 2/25 */
	}
}
