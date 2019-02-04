//(c) A+ Computer Science
//Name - James Maron
//Date - 1/31
//Class - APCSA
//Lab  - F101

public class AsciiBox {
	public static void main(String[] args) {
		System.out.println("James Maron \t  1/31 \n\n");
		for (int i = 0; i < 13; i++) {
			if (i % 5 == 4 || i % 5 == 3) {	
				System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA ");
			} else {
				System.out.println("+++++++++++++++++++++++++ ");
			}
		}
	}
}