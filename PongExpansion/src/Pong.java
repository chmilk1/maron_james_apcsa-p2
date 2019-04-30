
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable {
	private Ball ball;
	private Paddle paddle;
	private boolean[] keys;
	private ArrayList<Crushable> crushables;
	private int level = -1;
	private int countDown = -1;
	private int ballHitCountdown = -1;
	private final int RESET_BALL_FRAMES = 120;
	private final int HIT_IGNORE_FRAMES = 40;
	private double speedMultiplyer = 1;
	private boolean ballHit;
	private final static int BLOCK_WIDTH = 90;
	private final static int BLOCK_HEIGHT = 40;

	static private final Crushable[] level0 = { new Crushable(0, 100, BLOCK_HEIGHT, BLOCK_WIDTH, 0),
			new Crushable(100, 100, BLOCK_HEIGHT, BLOCK_WIDTH, 0), new Crushable(200, 100, BLOCK_HEIGHT, BLOCK_WIDTH, 0),
			new Crushable(300, 100, BLOCK_HEIGHT, BLOCK_WIDTH, 0), new Crushable(400, 100, BLOCK_HEIGHT, BLOCK_WIDTH, 0),
			new Crushable(500, 100, BLOCK_HEIGHT, BLOCK_WIDTH, 0),  new Crushable(700, 300, BLOCK_WIDTH, BLOCK_HEIGHT, 0), new Crushable(100, 300, BLOCK_WIDTH, BLOCK_HEIGHT, 0)};
	static private final Crushable[] level1 = { new Crushable(0, 100, BLOCK_HEIGHT, BLOCK_WIDTH, 1),
			new Crushable(100, 100, BLOCK_HEIGHT, BLOCK_WIDTH, 1), new Crushable(200, 100, BLOCK_HEIGHT, BLOCK_WIDTH, 1),
			new Crushable(300, 100, BLOCK_HEIGHT, BLOCK_WIDTH, 1), new Crushable(400, 100, BLOCK_HEIGHT, BLOCK_WIDTH, 1),
			new Crushable(500, 100, BLOCK_HEIGHT, BLOCK_WIDTH, 1), new Crushable(0, 200, BLOCK_HEIGHT, BLOCK_WIDTH, 1),
			new Crushable(100, 200, BLOCK_HEIGHT, BLOCK_WIDTH, 1), new Crushable(200, 200, BLOCK_HEIGHT, BLOCK_WIDTH, 1),
			new Crushable(300, 200, BLOCK_HEIGHT, BLOCK_WIDTH, 1), new Crushable(400, 200, BLOCK_HEIGHT, BLOCK_WIDTH, 1),
			new Crushable(500, 200, BLOCK_HEIGHT, BLOCK_WIDTH, 1) };
	static private final Crushable[] level2 = new Crushable[64];
	static private final Crushable[] level3 = new Crushable[128];
	static {
		int level = 0;
		for(int i = 0; i < level2.length; i++) {
			if(i > 0 && i%16 == 0) {
				level++;
			}
			level2[i] = new Crushable(i * 50 - level*800,level*50+50, 40, 40, 2);
		}
	}
	
	static {
		int level = 0;
		for(int i = 0; i < level3.length; i++) {
			if(i > 0 && i%16 == 0) {
				level++;
			}
			level3[i] = new Crushable(i * 50 - level*800,level*50+50, 40, 40, 2);
		}
	}
	
	static private final Crushable[][] levels = { level0, level1, level2, level3 };
	Random rand = new Random();

	public Pong() {
		// set up all variables related to the game
		ball = new Ball(TheGame.WIDTH / 2, TheGame.HEIGHT / 2, 10, 10, Color.black, 2, -2);
		paddle = new Paddle(TheGame.WIDTH / 2, 400, 40, 40, Color.DARK_GRAY, 7);
		crushables = new ArrayList<>();
		nextLevel();

		keys = new boolean[4];

		setBackground(Color.WHITE);
		setVisible(true);

		new Thread(this).start();
		addKeyListener(this); // starts the key thread to log key strokes
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void nextLevel() {
		level++;
		load(levels[level]);
	}

	public void load(Crushable[] level) {
		crushables.clear();
		for (Crushable c : level) {
			crushables.add(c);
		}
	}

	public void paint(Graphics window) {

		// EXPANDING PONG

		// window.setColor(Color.LIGHT_GRAY);
		// window.drawRect(-10, -10, 1000, 800);

		// ball.moveAndDraw(graphToBack);
		// leftPaddle.draw(graphToBack);
		// rightPaddle.draw(graphToBack);

		ball.moveAndDraw(window);
		paddle.draw(window);

		// System.out.println(ball.getX() + " x | y " + ball.getY());
		boolean levelOver = true;
		for (Crushable c : crushables) {
			if (c.isVisible) {
				c.draw(window);
				c.isColiding(ball, window);
				levelOver = false;
			}
		}
		if(levelOver) {
			nextLevel();
		}

		// see if the ball hits the top or side walls
		if (ball.getY() <= 0) {
			ball.setySpeed(-ball.getySpeed());
		}
		if (ball.getX() <= 0) {
			ball.setxSpeed(-ball.getxSpeed());
		}
		if (ball.getX() >= 800 - 40) {
			ball.setxSpeed(-ball.getxSpeed());
		}

		// see if ball hits bottem wall
		if (ball.getY() >= 600 - 40) {
			ball.drawOver(window);
			ball.setxSpeed(0);
			ball.setySpeed(0);
			ball.setX(400);
			ball.setY(300);
			countDown = RESET_BALL_FRAMES;
			load(levels[level]);
		}
		// see if the ball hits the right paddle
		if (!ballHit && ball.getX() < paddle.getX() + paddle.getWidth() && ball.getX() + ball.getWidth() > paddle.getX()
				&& ball.getY() < paddle.getY() + paddle.getHeight() && ball.getY() + ball.getHeight() > paddle.getY()) {
			ball.setxSpeed(-ball.getxSpeed());
			if (ball.getY() < paddle.getY() + paddle.getHeight() / 2) {
				ball.setySpeed(-2);
			} else {
				ball.setySpeed(2);
			}
			if (ball.getX() < paddle.getX() + paddle.getWidth() / 2) {
				ball.setxSpeed(-2);
			} else {
				ball.setxSpeed(2);
			}

			ballHit = true;
			ballHitCountdown = HIT_IGNORE_FRAMES;
		}

		if (countDown > 0) {
			countDown--;
		}
		if (countDown == 0) {
			ball.setxSpeed(rand.nextBoolean() ? 2 : -2);
			ball.setySpeed(-2);
			countDown = -1;
			speedMultiplyer = 1;
		}

		if (ballHitCountdown > 0) {
			ballHitCountdown--;
		}
		if (ballHitCountdown == 0) {
			ballHit = false;
			ballHitCountdown = -1;
		}
		// see if the paddles need to be moved

		// System.out.println(leftPaddle.getX() + " x | y " + leftPaddle.getY());
		// W
		if (keys[0]) {
			if (paddle.getY() > 0) {
				paddle.moveUpAndDraw(window);
			}
		}
		// A
		if (keys[1]) {
			if (paddle.getX() > 0) {
				paddle.moveLeftAndDraw(window);
			}
		}
		// S
		if (keys[2]) {
			if (paddle.getY() < TheGame.HEIGHT - paddle.getHeight() * 2) {
				paddle.moveDownAndDraw(window);
			}
		}
		// D
		if (keys[3]) {
			if (paddle.getX() < TheGame.WIDTH - paddle.getWidth() * 2) {
				paddle.moveRightAndDraw(window);
			}
		}

		// twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0] = true;
			break;
		case 'A':
			keys[1] = true;
			break;
		case 'S':
			keys[2] = true;
			break;
		case 'D':
			keys[3] = true;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0] = false;
			break;
		case 'A':
			keys[1] = false;
			break;
		case 'S':
			keys[2] = false;
			break;
		case 'D':
			keys[3] = false;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(8);
				repaint();
			}
		} catch (Exception e) {
		}
	}
}