import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Game extends Canvas implements KeyListener, Runnable {

	List<Entity> entitys;
	List<GameLogic> logic;

	private boolean w = false;
	private boolean s = false;
	private boolean a = false;
	private boolean d = false;

	public boolean isW() {return w;}

	public boolean isS() {return s;}

	public boolean isA() {return a;}

	public boolean isD() {return d;}

	private final boolean DEBUGGING = true;

	public Game() {
		this.addKeyListener(this);
		entitys = new ArrayList<>();
		logic = new ArrayList<>();

		if (DEBUGGING) {
			addGameLogic(new TestLogic(this));
		}
	}

	public void update() {
		for (Entity e : entitys) {
			e.update(this);
		}
		for (GameLogic l : logic) {
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
		if (arg0.getKeyChar() == 'w') {
			w = true;
		}
		if (arg0.getKeyChar() == 'a') {
			a = true;
		}
		if (arg0.getKeyChar() == 's') {
			s = true;
		}
		if (arg0.getKeyChar() == 'd') {
			d = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getKeyChar() == 'w') {
			w = false;
		}
		if (arg0.getKeyChar() == 'a') {
			a = false;
		}
		if (arg0.getKeyChar() == 's') {
			s = false;
		}
		if (arg0.getKeyChar() == 'd') {
			d = false;
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
