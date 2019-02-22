package elevens;

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** IMPLEMENTED IN ACTIVITY 1 *** 2/22 */
		Card a,b,c;
		a= new Card("Queen","Heart",12);
		b= new Card("Ace","Spades",14);
		c= new Card("2","Diamonds",2);
		System.out.println(b);
		System.out.println(a.rank() + " " + a.suit() + " " + a.pointValue());
		System.out.println(c.matches(a));
		System.out.println(c.matches(c));
	}
}
