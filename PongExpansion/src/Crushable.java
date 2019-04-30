import java.awt.Graphics;

public class Crushable extends Block {
	boolean isVisible;
	public Crushable(){
		super();
		isVisible = true;
	}
	
	public boolean isColiding(){
		return false;
	}
	
	public void breakBlock() {
		isVisible = true;
	}
	
	@Override
	public void draw(Graphics window) {
		if(isVisible) {
			super.draw(window);
		}
	}
}
