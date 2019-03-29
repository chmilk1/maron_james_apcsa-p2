import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Shell extends Entity{
	
	final Color COLOR = Color.YELLOW;
	
	private int width;
	private int height;
	
	private double GRAVITY = -.5;

	public Shell(int x, int y, int z, double velocity, double angle) {
		super(x,y,z);
		this.width = 6;
		this.height = 2;
		this.setyVel(velocity/Math.tan(angle));
		this.setxVel(velocity*Math.tan(angle));
		this.setzVel(5);
		this.setzAcl(GRAVITY);
		
	}
	
	@Override
	public void update(Game game) {
		if(getZ() < 0) {
			game.addToRemoveQue(this);
		}
		super.update(game);
	}
	
	@Override
	public void setPos(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(Entity o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics window) {
		window.setColor(COLOR);
		Graphics2D g2d = (Graphics2D) window;
		
		g2d.rotate(Math.atan(getyVel()/getxVel()), getX()+width/2, getY()+height/2);
		g2d.fillRect(getX(), getY(), width*(getZ()/3), height*(getZ()/3));
		
		g2d.rotate(-Math.atan(getyVel()/getxVel()));
		
	}

}
