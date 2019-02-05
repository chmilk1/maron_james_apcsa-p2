//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Maron
//Date - 2\1\19
//Class - APCSA
//Lab  - F101

import java.util.Scanner;

import javax.swing.JOptionPane;

import static java.lang.System.*;
import static java.lang.Math.*;

public class DistanceRunner
{
	public static void main( String[] args )
	{
		//takes in points and prints distance
		int x1 = Integer.parseInt(JOptionPane.showInputDialog("enter x1"));
		int x2 = Integer.parseInt(JOptionPane.showInputDialog("enter x2"));
		int y1 = Integer.parseInt(JOptionPane.showInputDialog("enter y1"));
		int y2 = Integer.parseInt(JOptionPane.showInputDialog("enter y2"));
		Distance dist = new Distance(x1, y1, x2, y2);
		dist.calcDistance();
		System.out.println(dist.toString());
		JOptionPane.showMessageDialog(null, "distance = " + String.format("%.3f",dist.getDistance()));
			
	}
}