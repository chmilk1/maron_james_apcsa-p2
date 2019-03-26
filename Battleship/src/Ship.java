import java.awt.Color;
import java.awt.Graphics;

public class Ship extends Entity{
	
	private int width;
	private int height;
	private Color color;

	public Ship(int x, int y, int z, int width, int height, Color c) {
		super(x,y,z);
		this.width = width;
		this.height = height;
		this.color = c;
	}
	
	@Override
	public void setPos(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(Entity arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics window) {
		window.setColor(color);
		window.drawRect(getX(), getY(), width, height);
		
	}

}
