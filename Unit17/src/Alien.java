
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing {
	private int speed;
	private Image image;

	public Alien() {
		this(0, 0, 30, 30, 0);
	}

	public Alien(int x, int y) {
		this(x, y, 30, 30, 5);
	}

	public Alien(int x, int y, int s) {
		this(x, y, 30, 30, s);
	}

	public Alien(int x, int y, int w, int h, int s) {
		super(x, y, w, h);
		this.speed = s;
		try {
			image = ImageIO.read(new File("src//alien.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setSpeed(int s) {
		this.speed = s;
	}

	public int getSpeed() {
		return speed;
	}

	public void move(String direction) {
		switch (direction.toLowerCase()) {
		case "up":
			setY(getY()-getSpeed());
			break;
		case "down":
			setY(getY()+getSpeed());
			break;
		case "right":
			setX(getX()+getSpeed());
			break;
		case "left":
			setX(getX()-getSpeed());
			break;

		default:
			break;
		}
	}

	public void draw(Graphics window) {
		window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
	}

	public String toString() {
		return "";
	}
}
