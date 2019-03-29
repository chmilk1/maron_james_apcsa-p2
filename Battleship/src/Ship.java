import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ship extends Entity{
	
	private int width;
	private int height;
	private Color color;
	
	protected double maxSpeed = 1.2;
	protected double accleration = 0.5;

	public Ship(int x, int y, int z, int width, int height, Color c) {
		super(x,y,z);
		this.width = width;
		this.height = height;
		this.color = c;
	}
	@Override
	public void update(Game game) {
		super.update(game);
	}
	


	@Override
	public int compareTo(Entity arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics window) {
		window.setColor(color);
		Graphics2D g2d = (Graphics2D) window;
		if(getyVel() != 0 || getyVel() != 0) {
		g2d.rotate(Math.atan(getyVel()/getxVel()), getX()+width/2, getY()+height/2);
		g2d.fillRect(getX(), getY(), width, height);
		g2d.rotate(-Math.atan(getyVel()/getxVel()));
		} else {
		g2d.fillRect(getX(), getY(), width, height);

		}
		
		
	}
	@Override
	public void setPos(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
