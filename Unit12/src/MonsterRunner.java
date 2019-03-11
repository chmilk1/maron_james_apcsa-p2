//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;

import javax.swing.JOptionPane;

import static java.lang.System.*;

public class MonsterRunner
{
	public static void main( String args[] )
	{
		while (true){
		//Scanner keyboard = new Scanner(System.in);
		Monster one = createMonster(1);
		Monster two = createMonster(2);
		JOptionPane.showMessageDialog(null, "Monster 1 - " + one + "\nMonster 2 - " + two);
		System.out.println("Monster 1 - " + one + "\nMonster 2 " + two);
		JOptionPane.showMessageDialog(null, two.isBigger(one) ? "Monster one is smaller than Monster two." : "Monster two is smaller than Monster one.");
		System.out.println(two.isBigger(one) ? "Monster one is smaller than Monster two." : "Monster two is smaller than Monster one.");
		JOptionPane.showMessageDialog(null, two.namesTheSame(one) ? "Monster one does not have the same name as Monster two." : "Monster one has the same name as Monster two.");
		System.out.println(!two.namesTheSame(one) ? "Monster one does not have the same name as Monster two." : "Monster one has the same name as Monster two.");
		System.out.println();
		}
	}
	static Monster createMonster(int run) {
		String name;
		int size = 0;
		name = JOptionPane.showInputDialog("Enter monster "+ run +"'s name :");
		size = Integer.parseInt(JOptionPane.showInputDialog("Enter monster "+ run +"'s size (int):"));
		return new Skeleton(size, name);
	}
}