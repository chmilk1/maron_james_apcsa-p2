/**
 * A program to carry on conversations with a human user. This is the initial
 * version that:
 * <ul>
 * <li>Uses indexOf to find strings</li>
 * <li>Handles responding to simple words and phrases</li>
 * </ul>
 * This version uses a nested if to handle default responses.
 * 
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2 {
	/**
	 * Get a default greeting
	 * 
	 * @return a greeting
	 */
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement) {
		String response = "";
		if (statement.length() < 1) {
			response = "Say something, please.";
		} else if (statement.indexOf("mother") >= 0 || statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0 || statement.indexOf("brother") >= 0) {
			response = "Tell me more about your family.";
		} else if (statement.toLowerCase().contains("dog") || statement.toLowerCase().contains("cat")) {
			response = "Tell me more about your pets";
		} else if (statement.toLowerCase().contains("mr mauro")) {
			response = "He is certainly the best teacher of all time.";
		} else if (statement.toLowerCase().contains("won")) {
			response = "Wow, you won?";
		} else if (statement.toLowerCase().contains("fun")) {
			response = "Ive always found that fun too.";
		} else if (statement.toLowerCase().contains("like")) {
			response = "I like that aswell";
		} else if (statement.indexOf("no") >= 0) {
			response = "Why so negative?";
		} else {
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * 
	 * @return a non-committal string
	 */
	private String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 7;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		switch (whichResponse) {
		case 0:
			response = "I know right?";
			break;
		case 1:
			response = "Intresting. Tell me more.";
			break;
		case 2:
			response = "Sounds cool.";
			break;
		case 3:
			response = "Hmmm.";
			break;
		case 4:
			response = "Do you really think so?";
			break;
		case 5:
			response = "You don't say.";
			break;
		case 6:
			response = "Is that all?";
			break;
		default:
			response = "Ok.";
			break;
		}

		return response;
	}
}
