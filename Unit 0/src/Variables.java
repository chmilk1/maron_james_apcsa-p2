//(c) A+ Computer Science
//www.apluscompsci.com

//Name - James Maron
//Date - 1/31
//Class -
//Lab  -

public class Variables {
	public static void main(String[] args) {
		// define 1 variable of each of the
		// following data types
		// byte short int long
		// float double
		// char boolean String

		// integer variables
		byte byteOne = 127;
		short shortOne = Short.MAX_VALUE;
		int intOne = Integer.MAX_VALUE;
		long longOne = Long.MAX_VALUE;

		// decimal variables
		float floatOne = Float.MAX_VALUE;
		double doubleOne = Double.MAX_VALUE;

		// other integer types
		char charOne = 'A';

		// other types
		boolean booleanOne = false;
		String stringOne = "Hello World";

		// output your information here
		System.out.println("/////////////////////////////////");
		System.out.println("*                               *");
		System.out.println("*        integer types          *");
		System.out.println("*                               *");
		System.out.println("*8 bits - byteOne = " + byteOne + "\t\t*");
		System.out.println("*16 bits - shortOne = " + shortOne + "\t\t*");
		System.out.println("*32 bits - intOne = " + intOne + "\t\t*");
		System.out.println("*64 bit - longOne = " + longOne + "\t\t*");
		System.out.println("*                               *");
		System.out.println("*        real types             *");
		System.out.println("*                               *");
		System.out.println("*32 bits - floatOne = " + floatOne + "\t\t*");
		System.out.println("*64 bits - doubleOne = " + doubleOne +"\t\t*");
		System.out.println("*        real types             *");
		System.out.println("*                               *");
		System.out.println("*16 bits - charOne = " + charOne + " - " + (int) charOne +"\t\t*");
		System.out.println("*        real types             *");
		System.out.println("*                               *");
		System.out.println("*String Table - stringOne = " + stringOne + "\t\t*");//its not really a primitive
		System.out.println("*8 bit - booleanOne = " + booleanOne + "\t\t*");

	}
}