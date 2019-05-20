/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 * 
 * @author Barbara Ericson
 */
public class PictureTester {
	/** Method to test zeroBlue */
	public static void testZeroBlue() {
		Picture beach = new Picture("src\\images\\beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

	/** Method to test mirrorVertical */
	public static void testMirrorVertical() {
		Picture caterpillar = new Picture("src\\images\\caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorVertical();
		caterpillar.explore();
	}

	/** Method to test mirrorTemple */
	public static void testMirrorTemple() {
		Picture temple = new Picture("src\\images\\temple.jpg");
		temple.explore();
		temple.mirrorTemple();
		temple.explore();
	}

	/** Method to test the collage method */
	public static void testCollage() {
		Picture canvas = new Picture("src\\images\\640x480.jpg");
		canvas.createCollage();
		canvas.explore();
	}

	/** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("src\\images\\swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }

	/**
	 * Main method for testing. Every class can have a main method in Java
	 */
	public static void main(String[] args) {
		// uncomment a call here to run a test
		// and comment out the ones you don't want
		// to run
		
		// easy
		
		// testZeroBlue();
		// testKeepOnlyBlue();
		// testKeepOnlyRed();
		// testKeepOnlyGreen();
		// testNegate();
		// testGrayscale();
		// testFixUnderwater();
		
		// medum
		
		// testMirrorVertical();
		// testMirrorHorizontal();
		// testMirrorTemple();
		// testMirrorArms();
		// testMirrorGull();
		// testMirrorDiagonal();
		
		// hard
		
		// testCollage();
		// testCopy();
		// testEdgeDetection(); //their method
		// testEdgeDetection2(); //my method

		// Finished
		// ^Due: Thursday, 25

		// testChromakey();
		 testEncodeAndDecode();
		// testGetCountRedOverValue(250);
		// testSetRedToHalfValueInTopHalf();
		// testClearBlueOverValue(200);
		// testGetAverageForColumn(0);
	}
	private static void testEncodeAndDecode() {
		Picture beach = new Picture("src\\images\\beach.jpg");
		Picture code = new Picture("src\\images\\msg2.jpg");
		beach.explore();
		code.explore();
		beach.encode(code);
		beach.explore();
		beach.decode();
		beach.explore();
		
		
	}

	//src\images\
	private static void testMirrorDiagonal() {
		// TODO Auto-generated method stub
		Picture beach = new Picture("src\\images\\koala.jpg");
		beach.explore();
		beach.mirrorDiag();
		beach.explore();
	}

	private static void testMirrorGull() {
		Picture beach = new Picture("src\\images\\seagull.jpg");
		beach.explore();
		beach.mirrorPart(false, 232, 333, 229, 345);
		beach.explore();
	}

	private static void testEdgeDetection2() {
		Picture beach = new Picture("src\\images\\swan.jpg");
		beach.explore();
		beach.jamesEdgeDetect();
		beach.explore();

	}

	private static void testCopy() {
		Picture beach = new Picture("src\\images\\swan.jpg");
		beach.explore();
		beach.copy(0, 100, 0, 100, 150, 150);
		beach.explore();

	}

	private static void testMirrorArms() {
		Picture beach = new Picture("src\\images\\snowman.jpg");
		beach.explore();
		beach.mirrorPart(true, 156, 191, 104, 169);
		beach.mirrorPart(true, 171, 194, 238, 293);
		beach.explore();
	}

	private static void testMirrorHorizontal() {
		Picture beach = new Picture("src\\images\\swan.jpg");
		beach.explore();
		beach.mirrorHorizontal();
		beach.explore();

	}

	private static void testFixUnderwater() {
		Picture beach = new Picture("src\\images\\water.jpg");
		beach.explore();
		// beach.modifyColors(1.75, .5, .5);
		beach.modifyColors(3, .9, .9);
		beach.explore();

	}

	private static void testKeepOnlyGreen() {
		Picture beach = new Picture("src\\images\\kitten2.jpg");
		beach.explore();
		beach.modifyColors(0, 1, 0);
		beach.explore();

	}

	private static void testKeepOnlyRed() {
		Picture beach = new Picture("src\\images\\kitten2.jpg");
		beach.explore();
		beach.modifyColors(1, 0, 0);
		beach.explore();

	}

	private static void testGrayscale() {
		Picture pic = new Picture("src\\images\\barbaraS.jpg");
		pic.explore();
		pic.grayScale();
		pic.explore();

	}

	private static void testNegate() {
		Picture pic = new Picture("src\\images\\swan.jpg");
		pic.explore();
		pic.negate();
		pic.explore();

	}

	private static void testKeepOnlyBlue() {
		Picture beach = new Picture("src\\images\\kitten2.jpg");
		beach.explore();
		beach.modifyColors(0, 0, 1);
		beach.explore();

	}
}