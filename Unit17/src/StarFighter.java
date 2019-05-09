//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import javax.swing.JFrame;
import java.awt.Component;

public class StarFighter extends JFrame
{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	public StarFighter()
	{
		super("STARFIGHTER");
		setSize(WIDTH,HEIGHT);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		OuterSpace theGame = new OuterSpace();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}

	public static void main( String args[] )
	{
		StarFighter run = new StarFighter();
	}
}