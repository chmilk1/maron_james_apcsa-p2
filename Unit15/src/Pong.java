
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
	private int countDown = -1;
	private final int RESET_BALL_FRAMES = 120;
	Random rand = new Random();

	public Pong() {
		// set up all variables related to the game
		ball = new Ball(200, 200, 40, 40, Color.black, 2, 2);
		leftPaddle = new Paddle(60, 200, 80, 20, Color.RED, 7);
		rightPaddle = new Paddle(700, 200, 80, 20, Color.BLUE, 7);

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
			ball.drawOver(window);
			ball.setxSpeed(0);
			ball.setySpeed(0);
			ball.setX(400);
			ball.setY(300);
			countDown = RESET_BALL_FRAMES;
		}
		
		if(countDown > 0) {
			countDown--;
		}
		if(countDown == 0) {
			ball.setxSpeed(-2);
			ball.setySpeed(-2);
			countDown = -1;
		}
		//System.out.println(ball.getX() + " x | y " + ball.getY());

		// see if the ball hits the top or bottom wall
		if (ball.getY() <= 40) {
			ball.setySpeed(-ball.getySpeed());
		}
		if (ball.getY() >= 560) {
			ball.setySpeed(-ball.getySpeed());
		}

		// see if the ball hits the left paddle
		if (ball.getX() < leftPaddle.getX()
				&& ball.getY() < leftPaddle.getY() && ball.getY() > leftPaddle.getY() + leftPaddle.getHeight()) {
			ball.setxSpeed(-(rand.nextInt(4) + 1));
			ball.setySpeed(rand.nextBoolean() ? rand.nextInt(4) : -rand.nextInt(4));
			System.out.println("left hit!");
		}
		// see if the ball hits the right paddle
		if (ball.getX() + ball.getWidth() > rightPaddle.getX()
				&& ball.getY() < rightPaddle.getY() && ball.getY() < leftPaddle.getY() + rightPaddle.getHeight()) {
			ball.setxSpeed((rand.nextInt(4)+1));
			ball.setySpeed(rand.nextBoolean() ? rand.nextInt(4) : -rand.nextInt(4));
			System.out.println("right hit!");
		}
		// see if the paddles need to be moved

		//System.out.println(leftPaddle.getX() + " x | y " + leftPaddle.getY());
		if (keys[0]) {
			if (leftPaddle.getY() <= 595 || leftPaddle.getY() < 0) {
				leftPaddle.moveUpAndDraw(window);
			}
		}
		if (keys[1]) {
			if (leftPaddle.getY() >= 5) {
				leftPaddle.moveDownAndDraw(window);
			}
		}
		if (keys[2]) {
			if (rightPaddle.getY() <= 595) {
				rightPaddle.moveUpAndDraw(window);
			}
		}
		if (keys[3]) {
			if (rightPaddle.getY() >= 5) {
				rightPaddle.moveDownAndDraw(window);
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