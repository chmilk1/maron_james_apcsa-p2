/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("H:\\workspace\\Unit16\\bin\\images\\beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("H:\\workspace\\Unit16\\bin\\images\\caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("H:\\workspace\\Unit16\\bin\\images\\temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("H:\\workspace\\Unit16\\bin\\images\\640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("src\\\\images\\\\swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
	//testMirrorHorizontal();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    testEdgeDetection();
    testEdgeDetection2();
    
    //^Due: Thursday, 25
    
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }

private static void testEdgeDetection2() {
	// TODO Auto-generated method stub
	
}

private static void testCopy() {
	Picture beach = new Picture("src\\images\\swan.jpg");
    beach.explore();
    beach.copy(0,100,0,100,150,150);
    beach.explore();
	
}

private static void testMirrorArms() {
	Picture beach = new Picture("H:\\workspace\\Unit16\\bin\\images\\snowman.jpg");
    beach.explore();
    beach.mirrorPart(-1, 170, 100, 200, 100, 200);;
    beach.explore();
}

private static void testMirrorHorizontal() {
	Picture beach = new Picture("H:\\workspace\\Unit16\\bin\\images\\swan.jpg");
    beach.explore();
    beach.mirrorHorizontal();
    beach.explore();
	
}

private static void testFixUnderwater() {
	Picture beach = new Picture("H:\\workspace\\Unit16\\bin\\images\\water.jpg");
    beach.explore();
    //beach.modifyColors(1.75, .5, .5);
    beach.modifyColors(3, .9, .9);
    beach.explore();
	
}

private static void testKeepOnlyGreen() {
	Picture beach = new Picture("H:\\workspace\\Unit16\\bin\\images\\kitten2.jpg");
    beach.explore();
    beach.modifyColors(0, 1, 0);
    beach.explore();
	
}

private static void testKeepOnlyRed() {
	Picture beach = new Picture("H:\\workspace\\Unit16\\bin\\images\\kitten2.jpg");
    beach.explore();
    beach.modifyColors(1, 0, 0);
    beach.explore();
	
}

private static void testGrayscale() {
	Picture pic = new Picture("H:\\workspace\\Unit16\\bin\\images\\barbaraS.jpg");
	pic.explore();
	pic.grayScale();
    pic.explore();
	
}

private static void testNegate() {
	Picture pic = new Picture("H:\\workspace\\Unit16\\bin\\images\\robot.jpg");
	pic.explore();
	pic.negate();
    pic.explore();
	
}

private static void testKeepOnlyBlue() {
	Picture beach = new Picture("H:\\workspace\\Unit16\\bin\\images\\kitten2.jpg");
    beach.explore();
    beach.modifyColors(0, 0, 1);
    beach.explore();
	
}
}