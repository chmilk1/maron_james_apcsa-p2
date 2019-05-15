//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
	private int speed;

	public Ammo()
	{
		this(0,0,0);
	}

	public Ammo(int x, int y)
	{
		this(x,y,6);
	}

	public Ammo(int x, int y, int s)
	{
		super(x,y,10,10);
		setSpeed(s);
	}

	public void setSpeed(int s)
	{
	   this.speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		window.setColor(Color.YELLOW);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
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

	public String toString()
	{
		return "";
	}
}
