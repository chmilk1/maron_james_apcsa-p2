import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game extends Canvas implements KeyListener, Runnable, MouseListener {

	List<Entity> entitys;
	List<GameLogic> logic;
	Click lastClick;
	private int tick = 0;
	
	private List<Entity> entitysToRemove = new ArrayList<>();

	HashMap<Character, Boolean> keys = new HashMap<>();

	private final boolean DEBUGGING = true;

	public Game() {
		lastClick = new Click(-1, -1, -1000);
		this.addKeyListener(this);
		this.addMouseListener(this);
		entitys = new ArrayList<>();
		logic = new ArrayList<>();

		if (DEBUGGING) {
			addGameLogic(new TestLogic(this));
		}
	}
	
	private void removeEs() {
		for(Object e : entitysToRemove) {
			entitys.remove(e);
		}
	}
	
	public void addToRemoveQue(Entity e) {
		entitysToRemove.add(e);
	}
	
	public Click getClick() {
		return lastClick;
	}
	
	public void setClick(Click c) {
		this.lastClick = c;
	}
	
	public int getTick() {
		return tick;
	}

	public boolean isPressed(char c) {
		if (keys.containsKey(c)) {
			return keys.get(c);
		}
		return false;
	}

	public void update() {
		//do click add here
		for (Entity e : entitys) {
			e.update(this);
		}
		for (GameLogic l : logic) {
			l.update(this);
		}
		removeEs();
		tick += 1;
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
		g.setColor(Color.cyan);
		g.fillRect(0, 0, Tester.WIDTH, Tester.HEIGHT);
		for (Entity e : entitys) {
			e.draw(g);
		}
	}

	@Override
	public void run() {
		update();

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println(arg0.getKeyChar());
		keys.put(arg0.getKeyChar(), true);

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		keys.put(arg0.getKeyChar(), false);

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("click");
		setClick(new Click(e.getX(), e.getY(), tick));  
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
