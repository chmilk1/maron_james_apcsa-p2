import javax.swing.JFrame;
import java.awt.Component;

public class Tester extends JFrame
{
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 600;

	public Tester()
	{
		super("BattleShip by James Maron");
		setSize(WIDTH,HEIGHT);
		
		Game g = new Game();
		getContentPane().add(g);

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		Tester run = new Tester();
	}
}