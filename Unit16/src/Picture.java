import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super() child
		 * constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName the name of the file to create the picture from
	 */
	public Picture(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height the height of the desired picture
	 * @param width  the width of the desired picture
	 */
	public Picture(int height, int width) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image the buffered image to use
	 */
	public Picture(BufferedImage image) {
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName, height
	 *         and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	/** Method to set the blue to 0 */
	public void zeroBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
			}
		}
	}

	public void modifyColors(double redMulti, double greenMulti, double bluMulti) {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				int red = (int) (redMulti * pixelObj.getRed());
				int green = (int) (greenMulti * pixelObj.getGreen());
				int blue = (int) (bluMulti * pixelObj.getBlue());
				pixelObj.setBlue(blue > 255 ? 255 : blue);
				pixelObj.setGreen(green > 255 ? 255 : green);
				pixelObj.setRed(red > 255 ? 255 : red);
			}
		}
	}

	public void jamesEdgeDetect() {
		Picture edited = new Picture(this);
		Pixel[][] OurPixels = this.getPixels2D();
		Pixel[][] theirPixels = edited.getPixels2D();
		for (int row = 0; row < OurPixels.length; row++) {
			for (int col = 0; col < OurPixels[0].length; col++) {
				if (isEdge(OurPixels, row, col)) {
					theirPixels[row][col].setColor(Color.BLACK);
				} else {
					theirPixels[row][col].setColor(Color.WHITE);
				}
			}
		}
		this.copyPicture(edited);

	}

	// change this to change how much edge is detected
	public static final double EDGE_DIFF = 20;

	public boolean isEdge(Pixel[][] pixeles, int row, int col) {
		// up
		if (row > 0 && getPrecentDiff(pixeles[row][col], pixeles[row - 1][col]) >= EDGE_DIFF) {
			return true;
		}
		// down
		else if (row < pixeles.length - 1 && getPrecentDiff(pixeles[row][col], pixeles[row + 1][col]) >= EDGE_DIFF) {
			return true;
		}
		// left
		else if (col > 0 && getPrecentDiff(pixeles[row][col], pixeles[row][col - 1]) >= EDGE_DIFF) {
			return true;
		}
		// right
		else if (col < pixeles[0].length - 1 && getPrecentDiff(pixeles[row][col], pixeles[row][col + 1]) >= EDGE_DIFF) {
			return true;
		}
		return false;

	}

	public double getPrecentDiff(Pixel mainPix, Pixel edgePix) {
		double red = Math.abs((mainPix.getRed() + 1) - (edgePix.getRed() + 1));
		double blue = Math.abs((mainPix.getBlue() + 1) - (edgePix.getBlue() + 1));
		double green = Math.abs((mainPix.getGreen() + 1) - (edgePix.getGreen() + 1));
		return (Math.max(red, Math.max(blue, green)));
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of the
	 * picture from left to right
	 */
	public void mirrorVertical() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void mirrorDiag() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		int height = pixels.length;
		for (int middle = 0; middle < width && middle < height; middle++) {
			for (int sec = 0; sec < middle && sec < width; sec++) {
				leftPixel = pixels[middle][sec];
				rightPixel = pixels[sec][middle];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple() {
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++) {
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++) {

				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
				count++;
			}
		}
		System.out.println(count);
	}

	public void mirrorPart(boolean mirrorRow, int rowStart, int rowEnd, int colStart, int colEnd) {
		// loop through the rows
		if (mirrorRow) {
			Pixel[][] pixels = this.getPixels2D();
			Pixel topPixel = null;
			Pixel bottemPixel = null;
			int width = pixels[0].length;
			for (int row = rowStart; row < rowEnd; row++) {
				for (int col = colStart; col < colEnd; col++) {
					topPixel = pixels[row][col];
					bottemPixel = pixels[rowEnd + (row - rowStart)][col];
					bottemPixel.setColor(topPixel.getColor());
				}
			}
		} else {
			Pixel[][] pixels = this.getPixels2D();
			Pixel leftPixel = null;
			Pixel rightPixel = null;
			int width = pixels[0].length;
			for (int row = rowStart; row < rowEnd; row++) {
				for (int col = colStart; col < colEnd; col++) {
					leftPixel = pixels[row][col];
					rightPixel = pixels[row][colEnd + (col - colStart)];
					rightPixel.setColor(leftPixel.getColor());
				}
			}
		}
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in the
	 * current picture
	 * 
	 * @param fromPic  the picture to copy from
	 * @param startRow the start row to copy to
	 * @param startCol the start col to copy to
	 */
	public void copy(int rowStart, int rowEnd, int colStart, int colEnd, int rowTo, int colTo) {
		Pixel[][] toPixels = this.getPixels2D();
		for (int row = 0; row < rowEnd - rowStart; row++) {
			for (int col = 0; col < colEnd - rowStart; col++) {
				toPixels[row + rowTo][col + colTo].setColor(toPixels[row + rowStart][col + colStart].getColor());
			}
		}
	}

	public void copy(Picture fromPic, int startRow, int startCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	/** Method to create a collage of several pictures */
	public void createCollage() {
		Picture flower1 = new Picture("src\\images\\flower1.jpg");
		Picture flower2 = new Picture("src\\images\\flower2.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("src\\images\\collage.jpg");
	}

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist the distance for finding edges
	 */
	public void edgeDetection(int edgeDist) {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				rightColor = rightPixel.getColor();
				if (leftPixel.colorDistance(rightColor) > edgeDist)
					leftPixel.setColor(Color.BLACK);
				else
					leftPixel.setColor(Color.WHITE);
			}
		}
	}

	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	// public static void main(String[] args) {
	// Picture beach = new
	// Picture("H:\\workspace\\Unit16\\src\\images\\george.jpg");
	// beach.explore();
	// beach.zeroBlue();
	// beach.explore();
	// }

	public void mirrorHorizontal() {
		Pixel[][] pixels = this.getPixels2D();
		for (int y = 0; y < pixels.length; y++) {
			for (int x = 0; x < pixels[y].length; x++) {
				pixels[pixels.length - y - 1][x].setColor(pixels[y][x].getColor());
			}
		}
	}

	public void negate() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(255 - pixelObj.getBlue());
				pixelObj.setGreen(255 - pixelObj.getGreen());
				pixelObj.setRed(255 - pixelObj.getRed());
			}
		}
	}

	public void grayScale() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				int avg = (pixelObj.getBlue() + pixelObj.getGreen() + pixelObj.getRed()) / 3;
				pixelObj.setBlue(avg);
				pixelObj.setGreen(avg);
				pixelObj.setRed(avg);
			}
		}

	}

	public void encode(Picture code) {
		Pixel[][] pixels = this.getPixels2D();
		pixels[0][0].setColor(Color.RED);
		Pixel[][] codePixels = code.getPixels2D();
		for (int y = 0; y < pixels.length; y++) {
			for (int x = 0; x < pixels[0].length; x++) {
				if (y != 0 && x > 2) {
					Pixel redPx = pixels[y][x];
					Pixel greenPx;
					Pixel bluePx;
					if (x <= 1) {
						if (x == 0) {
							greenPx = pixels[y][x - 1];
							bluePx = pixels[y - 1][pixels[y - 1].length - 1];
						} else {
							greenPx = pixels[y - 1][pixels[y - 1].length - 1];
							bluePx = pixels[y - 1][pixels[y - 1].length - 2];
						}
					} else {
						greenPx = pixels[y][x - 1];
						bluePx = pixels[y][x - 2];
					}

					if (codePixels[y][x].getRed() < 127 && codePixels[y][x].getGreen() < 127
							&& codePixels[y][x].getBlue() < 127) {
						System.out.println("coded");
						redPx.setRed(getEven(redPx.getRed()));
						bluePx.setBlue(getEven(bluePx.getBlue()));
						greenPx.setGreen(getEven(greenPx.getGreen()));
					} else {
						System.out.print("not");
						redPx.setRed(getOdd(redPx.getRed()));
						bluePx.setBlue(getOdd(bluePx.getBlue()));
						greenPx.setGreen(getOdd(greenPx.getGreen()));
					}

				} else {
					// pixels[y][x].setRed(getOdd(pixels[y][x].getRed()));
				}
			}
		}

	}

	Random rand = new Random();

	public int getOdd(int x) {
		if (x > 253) {
			return 255;
		}
		if (x % 2 == 1 || x % 10 == 0) {
			return x;
		}
		return x - 1;
	}

	public int getEven(int x) {
		if (x > 253) {
			return 254;
		}
		if (x % 2 == 0 && x % 10 != 0) {
			return x;
		} else if (x % 10 == 0) {
			return x + 2;
		} else if (x % 10 == 1) {
			return x + 1;
		}
		return x - 1;
	}

	public void decode() {
		Pixel[][] pixels = this.getPixels2D();
		XYLOOP : for (int y = pixels.length - 1; y >= 0; y--) {
			for (int x = pixels[0].length - 1; x >= 0; x--) {
				
				if(y == 0 && x < 3) {
					break XYLOOP;
				}
				// ----------------------------------
				int red = pixels[y][x].getRed();
				int green = 0;
				int blue = 0;
				if (x <= 1) {
					if (x == 0) {
						green = pixels[y - 1][pixels[y - 1].length - 1].getGreen();
						blue = pixels[y - 1][pixels[y - 1].length - 2].getBlue();

					} else {
						green = pixels[y][x - 1].getGreen();
						blue = pixels[y - 1][pixels[y - 1].length - 1].getBlue();
					}
				} else {
					green = pixels[y][x - 1].getGreen();
					blue = pixels[y][x - 2].getBlue();
				}

//				System.out.println(isCoded(red) + " " + red + " " + isCoded(green) + " " + green + " " + isCoded(blue)
//						+ " " + blue + ":" + x + " " + y);

				// ----------------------------------
				if (isCoded(red) && isCoded(green) && isCoded(blue)) {
					pixels[y][x].setColor(Color.BLACK);
				} else {
					pixels[y][x].setColor(Color.WHITE);
				}

			}
		}

	}

	public boolean isCoded(int val) {
		return val % 2 == 0 && val % 10 != 0;

	}

} // this } is the end of class Picture, put all new methods before this
