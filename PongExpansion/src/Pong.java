
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
	
	static private final Crushable[] level0 = {new Crushable()};
	static private final Crushable[] level1 = {new Crushable()};
	static private final Crushable[][] levels = {level0, level1};
	Random rand = new Random();

	public Pong() {
		// set up all variables related to the game
		ball = new Ball(200, 200, 10, 10, Color.black, 2, 2);
		paddle = new Paddle(TheGame.WIDTH/2, 200, 40, 40, Color.DARK_GRAY, 7);
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
		for(Crushable c : level) {
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
		for(Crushable c : crushables) {
			c.draw(window);
			if(c.isVisible) {
				levelOver = false;
			}
		}

		// see if the ball hits the top or side walls
		if (ball.getY() <= 0) {
			ball.setySpeed(-ball.getySpeed());
		}
		if (ball.getX() <= 0) {
			ball.setxSpeed(-ball.getxSpeed());
		}
		if (ball.getX() >= 800-40) {
			ball.setxSpeed(-ball.getxSpeed());
		}
		
		//see if ball hits bottem wall
		if (ball.getY() >= 600-40) {
			ball.setySpeed(-ball.getySpeed());
		}
		// see if the ball hits the right paddle
//		if (ball.getX() + ball.getWidth() > rightPaddle.getX() && ball.getY() + ball.getHeight() > rightPaddle.getY()
//				&& rightPaddle.getY() + rightPaddle.getHeight() > ball.getY() && !ballHit) {
//			ball.setxSpeed((int) (-(rand.nextInt(1) + 2) * speedMultiplyer));
//			ball.setySpeed(rand.nextBoolean() ? rand.nextInt(3) + 1 : -rand.nextInt(3) - 1);
//
//			speedMultiplyer += .2;
//			// System.out.println("right hit!");
//
//			ballHit = true;
//			ballHitCountdown = HIT_IGNORE_FRAMES;
//		}

		if (ballHitCountdown > 0) {
			ballHitCountdown--;
		}
		if (ballHitCountdown == 0) {
			ballHit = false;
			ballHitCountdown = -1;
		}
		// see if the paddles need to be moved

		// System.out.println(leftPaddle.getX() + " x | y " + leftPaddle.getY());
		//W
		if (keys[0]) {
			paddle.moveUpAndDraw(window);
		}
		//A
		if (keys[1]) {
			
		}
		//S
		if (keys[2]) {
			paddle.moveDownAndDraw(window);
		}
		//D
		if (keys[3]) {
			
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