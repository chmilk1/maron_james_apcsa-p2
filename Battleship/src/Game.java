import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Game extends Canvas implements KeyListener, Runnable{

	List<Entity> entitys;
	List<GameLogic> logic;
	
	public Game() {
		entitys = new ArrayList<>();
		logic = new ArrayList<>();
	}
	
	public void update() {
		for(Entity e : entitys) {
			e.update(this);
		}
		for(GameLogic l : logic) {
			l.update(this);
		}
	}
	
	public void addEntity(Entity e) {
		entitys.add(e);
	}
	public void addGameLogic(GameLogic logic) {
		logic.start(this);
		this.logic.add(logic);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(Entity e : entitys) {
			e.draw(g);
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
