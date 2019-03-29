import java.awt.Color;
import java.awt.Graphics;

public class Player1Ship extends Ship{
	
	private int width;
	private int height;
	private Color color;
	

	public Player1Ship(int x, int y, int z, int width, int height, Color c) {
		super(x, y, z, width, height, c);
		maxSpeed = 1.2;
		accleration = .5;
	}
	@Override
	public void update(Game game) {
		if(game.isPressed('w')) {
			setyAcl(-accleration);
		}
		if(game.isPressed('s')) {
			setyAcl(accleration);
		}
		if(game.isPressed('a')) {
			setxAcl(-accleration);
		}
		if(game.isPressed('d')) {
			setxAcl(accleration);
		}
		if(game.isPressed(' ')) {
			setxVel(0);
			setyVel(0);
			
			setyAcl(0);
			setxAcl(0);
		}
		
		if(game.getClick().getTick() - game.getTick() < 2 && game.getClick().getTick() - game.getTick() > -2) {
			fire(game);
		}
		super.update(game);
	}
	
	private void fire(Game game) {
		double ratio = game.getClick().getY()-getY()/game.getClick().getX()-getX();
		game.addEntity(new Shell(getX(), getY(), 0, 2, Math.atan(ratio)));
		
	}
	@Override
	public void setxVel(double d) {
		if(Math.abs(d) > maxSpeed) {
			super.setxVel(maxSpeed);
		} else {
			super.setxVel(d);
		}
	}
	
	@Override
	public void setyVel(double d) {
		if(Math.abs(d) > maxSpeed) {
			super.setyVel(maxSpeed);
		} else {
			super.setyVel(d);
		}
	}
	
//	@Override
//	public void setxAcl(double xAcl) {
//		if(Math.abs(getxVel()+xAcl) > maxSpeed) {
//			super.setxAcl(0);
//		} else {
//			super.setxAcl(xAcl);
//		}
//	}
//	
//	@Override
//	public void setyAcl(double yAcl) {
//		if(Math.abs(getyVel()+yAcl) > maxSpeed) {
//			super.setyAcl(0);
//		} else {
//			super.setyAcl(yAcl);
//		}
//	}
	

}
