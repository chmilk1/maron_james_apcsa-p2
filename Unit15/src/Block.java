
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable {
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block() {

	}
	
	public Block(int x, int y) {
		setX(x);
		setY(y);
	}

	public Block(int x, int y, int height, int width, Color color) {
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		setColor(color);

	}

	public void setColor(Color col) {
		this.color = col;

	}

	public void drawOver(Graphics window) {
		window.setColor(Color.WHITE);
		window.fillRect(getX(), getY(), getWidth(), getHeight());

	}
	public void draw(Graphics window) {
		window.setColor(color);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void draw(Graphics window, Color col) {
		window.setColor(col);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public boolean equals(Object obj) {
		if(obj.getClass() != this.getClass()) {
			return false;
		}
		return ("" + obj.toString()).equals(this.toString());
	}

	@Override
	public void setPos(int x, int y) {
		this.xPos = x;
		this.yPos = y;
		
	}

	@Override
	public void setX(int x) {
		this.xPos = x;
		
	}

	@Override
	public void setY(int y) {
		this.yPos = y;
		
	}

	@Override
	public int getX() {
		return xPos;
	}

	@Override
	public int getY() {
		return yPos;
	}

	// add the other get methods

	// add a toString() method - x , y , width, height, color
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return xPos + " " + yPos + " | " + width + " " + height + " | " + color;
	}
}