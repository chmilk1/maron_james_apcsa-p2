
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable {
	private Ship ship;
	private ArrayList<Ammo> bullets = new ArrayList<>();
	private ArrayList<Alien> alienHorde = new ArrayList<>();
	private int shootTimer = -1;
	private final int SHOOT_RESET = 30;
	private final int ALIENS_PER_ROW = 10;
	private final int ROWS = 2;
	boolean gameOver = false;
	boolean gameWin = false;

	/*
	 * uncomment once you are ready for this part
	 *
	 * private AlienHorde horde; private Bullets shots;
	 */

	private boolean[] keys;
	private BufferedImage back;


	public OuterSpace() {
		setBackground(Color.black);

		keys = new boolean[5];

		// instantiate other instance variables
		// Ship, Alien
		ship = new Ship(StarFighter.WIDTH / 2, StarFighter.HEIGHT / 2, 40, 40, 5);

		for (int row = 0; row < ROWS; row++) {
			for (int i = 0; i < ALIENS_PER_ROW; i++) {
				alienHorde.add(new Alien(i * (StarFighter.WIDTH / ALIENS_PER_ROW), 40 + row * 80));
			}
		}

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		 Font font = new Font("Verdana", Font.BOLD, 30);
		 window.setFont(font);

		// set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D) window;

		// take a snap shop of the current screen and same it as an image
		// that is the exact same width and height as the current screen
		if (back == null)
			back = (BufferedImage) (createImage(getWidth(), getHeight()));

		// create a graphics reference to the back ground image
		// we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		graphToBack.setFont(font);

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50);
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0, 0, 800, 600);

		// add code to move Ship, Alien, etc.

		if (!gameOver && keys[0] == true && ship.getX() > 0) {
			ship.move("LEFT");
		}
		if (!gameOver && keys[1] == true && ship.getX() + ship.getWidth() + 10 < StarFighter.WIDTH) {
			ship.move("RIGHT");
		}
		if (!gameOver && keys[2] == true && ship.getY() > 0) {
			ship.move("UP");
		}
		if (!gameOver && keys[3] == true && ship.getY() + ship.getHeight() * 2 < StarFighter.HEIGHT) {
			ship.move("DOWN");
		}
		
		if(!gameOver) {
		ship.draw(graphToBack);
		}

		for (Alien a : alienHorde) {
			if (a.getX() < 0) {
				a.moveRight = true;
				a.move("DOWN");
			}
			if (a.getX() + a.getWidth() > StarFighter.WIDTH) {
				a.moveRight = false;
				a.move("DOWN");
			}
			if(a.getY() > StarFighter.HEIGHT - a.getHeight()) {
				gameOver = true;
			}
			
			if (ship.getX() < a.getX() + a.getWidth() && ship.getX() + ship.getWidth() > a.getX()
					&& ship.getY() < a.getY() + a.getHeight() && ship.getY() + ship.getHeight() > a.getY()) {
				gameOver = true;
			}
			
			a.move();
			a.draw(graphToBack);
		}

		if (keys[4] == true && shootTimer < 0 && !gameOver) {
			bullets.add(new Ammo(ship.getX() + ship.getWidth() / 2 - 5, ship.getY()));
			shootTimer = SHOOT_RESET;
		}

		if (shootTimer > -1) {
			shootTimer--;
		}
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).move("up");
			bullets.get(i).draw(graphToBack);
			if (bullets.get(i).getY() < 0) {
				bullets.remove(i);
				// System.out.println("Bye!");
				break;
			}
			for (int j = 0; j < alienHorde.size(); j++) {
				if (alienHorde.get(j).checkCollision(bullets.get(i))) {
					bullets.remove(i);
					alienHorde.remove(j);
					// System.out.println("Hit!");
					break;
				}
			}
		}
		if(alienHorde.isEmpty()) {
			gameWin = true;
		}

		// add in collision detection to see if Bullets hit the Aliens and if Bullets
		// hit the Ship
		if (gameOver) {
			graphToBack.setColor(Color.white);
			graphToBack.drawString("Game Over", 50, 50);
			
		} else if(gameWin) { 
			graphToBack.setColor(Color.white);
			graphToBack.drawString("You Win!", 50, 50);
		}
			twoDGraph.drawImage(back, null, 0, 0);

		
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e) {
		// no code needed here
	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(5);
				repaint();
			}
		} catch (Exception e) {
		}
	}
}
