import javax.swing.JFrame;
import java.awt.Component;
import java.util.Timer;
import java.util.TimerTask;

public class Tester extends JFrame
{
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 600;

	public Tester()
	{
		super("BattleShip by James Maron");
		setSize(WIDTH,HEIGHT);
		
		Game g = new Game();
		getContentPane().add(g);

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				g.update();
				g.repaint();
			}
		},  34, 34);
	}

	public static void main( String args[] )
	{
		Tester run = new Tester();
	}
}