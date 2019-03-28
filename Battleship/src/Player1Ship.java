import java.awt.Color;
import java.awt.Graphics;

public class Player1Ship extends Entity{
	
	private int width;
	private int height;
	private Color color;

	public Player1Ship(int x, int y, int z, int width, int height, Color c) {
		super(x,y,z);
		this.width = width;
		this.height = height;
		this.color = c;
	}
	@Override
	public void update(Game game) {
		if(game.isW()) {
			setyAcl(5);
		}
		if(game.isS()) {
			setyAcl(-5);
		}
		if(game.isA()) {
			setxAcl(5);
		}
		if(game.isD()) {
			setxAcl(-5);
		}
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
		window.fillRect(getX(), getY(), width, height);
		
	}
	@Override
	public void setPos(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
