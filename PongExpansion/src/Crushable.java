import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Crushable extends Block {
	boolean isVisible;

	public Crushable() {
		super();
		isVisible = true;
	}

	public Crushable(int x, int y, int width, int height) {
		super(x, y, width, height, getRandomColor());
		isVisible = true;
	}
	
	public Crushable(int x, int y, int width, int height, int muter) {
		super(x, y, width, height, getRandomColor(muter));
		isVisible = true;
	}

	public boolean isColiding(Ball ball, Graphics window) {
		if (ball.getX() < getX() + getWidth() && ball.getX() + ball.getWidth() > getX()
				&& ball.getY() < getY() + getHeight() && ball.getY() + ball.getHeight() > getY()) {
			ball.setySpeed(-ball.getySpeed());
			drawOver(window);
			breakBlock();
		}
		return false;
	}

	public void breakBlock() {
		isVisible = false;
	}

	@Override
	public void draw(Graphics window) {
		if (isVisible) {
			super.draw(window);
		}
	}
	
	public static Color getRandomColor() {
		Random rand = new Random();
		return new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
	}

	public static Color getRandomColor(int muter) {
		Random rand = new Random();
		if(muter == 0) {
			return new Color(rand.nextInt(63), rand.nextInt(255), rand.nextInt(63));
		} else if(muter == 1) {
			return new Color(rand.nextInt(255), rand.nextInt(63), rand.nextInt(63));
		} else {
			return new Color(rand.nextInt(63), rand.nextInt(63), rand.nextInt(255));
		}
		
	}
}
