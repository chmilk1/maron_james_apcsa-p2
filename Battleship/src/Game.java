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
	private int tick = 0;

	private List<Entity> entitysToRemove = new ArrayList<>();

	HashMap<Character, Boolean> keys = new HashMap<>();

	private final boolean DEBUGGING = true;

	public Game() {
		this.addKeyListener(this);
		this.addMouseListener(this);
		entitys = new ArrayList<>();
		logic = new ArrayList<>();

		if (DEBUGGING) {
			addGameLogic(new TestLogic(this));
		}
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
		for (Entity e : entitys) {
			e.update(this);
		}
		for (GameLogic l : logic) {
			l.update(this);
		}
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
		for(Entity ent : entitys) {
			if (ent.getClass() == Player1Ship.class) {
				((Player1Ship)ent).fire(new Click(e.getX(), e.getY(), tick),this);
			}
		}
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
