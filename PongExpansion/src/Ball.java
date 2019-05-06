
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block {
	private int xSpeed;
	private int ySpeed;

	public Ball() {
		super(200, 200);
		xSpeed = 3;
		ySpeed = 1;
	}

	public Ball(int x, int y, int h, int w, Color c) {
		super(x, y, h, w, c);
		xSpeed = 3;
		ySpeed = 1;
	}

	public Ball(int x, int y, int h, int w, Color c, int xs, int ys) {
		super(x, y, h, w, c);
		xSpeed = xs;
		ySpeed = ys;
	}

	// add the other Ball constructors

	// add the set methods

	public void moveAndDraw(Graphics window) {
		drawOver(window);
		setX(getX() + xSpeed);
		setY(getY() + ySpeed);
		super.draw(window);
		// setY

		// draw the ball at its new location
	}

	public int getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	public int getySpeed() {
		return ySpeed;
	}

	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}

	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			if(!obj.getClass().equals(this.getClass())) {
				return false;
			}
			if(xSpeed==((Ball) obj).xSpeed && xSpeed==((Ball) obj).ySpeed) {
				return true;
			}
		}
		return false;
	}

	// add the get methods

	// add a toString() method
}