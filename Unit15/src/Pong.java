
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
import java.util.Random;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable {
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	Random rand = new Random();

	public Pong() {
		// set up all variables related to the game
		ball = new Ball(200, 200, 40, 40, Color.black, 1, 1);
		leftPaddle = new Paddle(10, 200, 80, 20, Color.RED, 7);
		rightPaddle = new Paddle(750, 200, 80, 20, Color.BLUE, 7);

		keys = new boolean[4];

		setBackground(Color.WHITE);
		setVisible(true);

		new Thread(this).start();
		addKeyListener(this); // starts the key thread to log key strokes
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {

		// set up the double buffering to make the game animation nice and smooth
		// Graphics2D twoDGraph = (Graphics2D) window;

		// take a snap shop of the current screen and same it as an image
		// that is the exact same width and height as the current screen
		// if (back == null)
		// back = (BufferedImage) (createImage(getWidth(), getHeight()));

		// create a graphics reference to the back ground image
		// we will draw all changes on the background image
		// Graphics graphToBack = back.createGraphics();

		// window.setColor(Color.LIGHT_GRAY);
		// window.drawRect(-10, -10, 1000, 800);

		// ball.moveAndDraw(graphToBack);
		// leftPaddle.draw(graphToBack);
		// rightPaddle.draw(graphToBack);

		ball.moveAndDraw(window);
		leftPaddle.draw(window);
		rightPaddle.draw(window);

		// see if ball hits left wall or right wall
		if (!(ball.getX() >= 10 && ball.getX() <= 760)) {
			ball.setxSpeed(0);
			ball.setySpeed(0);
			ball.setX(400);
			ball.setY(300);
		}
		//System.out.println(ball.getX() + " x | y " + ball.getY());

		// see if the ball hits the top or bottom wall
		if (ball.getY() <= -5) {
			ball.setySpeed(-ball.getY());
		}
		if (ball.getY() >= 595) {
			ball.setySpeed(-ball.getY());
		}

		// see if the ball hits the left paddle
		if (ball.getX() < 30 && ball.getY() < leftPaddle.getY() && ball.getY() < leftPaddle.getHeight()) {
			ball.setxSpeed(-1 - rand.nextInt(3));
			ball.setySpeed(rand.nextBoolean() ? rand.nextInt(4) : -rand.nextInt(4));
		}
		// see if the ball hits the right paddle
		if (ball.getX() > 740 && ball.getY() < rightPaddle.getY() && ball.getY() < rightPaddle.getHeight()) {
			ball.setxSpeed(-1 - rand.nextInt(3));
			ball.setySpeed(rand.nextBoolean() ? rand.nextInt(4) : -rand.nextInt(4));
		}
		// see if the paddles need to be moved

		System.out.println(leftPaddle.getX() + " x | y " + leftPaddle.getY());
		if (keys[0]) {
			if (leftPaddle.getY() <= 595 || leftPaddle.getY() < 0) {
				leftPaddle.moveDownAndDraw(window);
			}
		}
		if (keys[1]) {
			if (leftPaddle.getY() >= 5) {
				leftPaddle.moveUpAndDraw(window);
			}
		}
		if (keys[2]) {
			if (rightPaddle.getY() <= 595) {
				rightPaddle.moveDownAndDraw(window);
			}
		}
		if (keys[3]) {
			if (rightPaddle.getY() >= 5) {
				rightPaddle.moveUpAndDraw(window);
			}
		}

		// twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0] = true;
			break;
		case 'Z':
			keys[1] = true;
			break;
		case 'I':
			keys[2] = true;
			break;
		case 'M':
			keys[3] = true;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0] = false;
			break;
		case 'Z':
			keys[1] = false;
			break;
		case 'I':
			keys[2] = false;
			break;
		case 'M':
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