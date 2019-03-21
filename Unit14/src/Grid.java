import java.util.Arrays;
import java.util.HashMap;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Grid
{
   private String[][] grid;

   //load vals into the rows x cols grid randomly
	public Grid(int rows, int cols, String[] vals)
	{
		grid = new String[rows][cols];
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < cols; y++) {
				grid[x][y] = vals[(int) (Math.random()*(vals.length))];
			}
		}
	}
	public String findMax(String[] vals)
	{
		return null;
	}

	//find out which of the vals occurs the most
	public String findMax()
	{
		HashMap<String, Integer> freq= new HashMap<>();
		for(int x = 0; x < grid.length; x++) {
			for(int y = 0; y < grid[0].length; y++) {
				if(freq.containsKey(grid[x][y])) {
					freq.put(grid[x][y], freq.get(grid[x][y])+1);
				} else {
					freq.put(grid[x][y], 1);
				}
			}
		}
		String mostCommon = "" + freq.keySet().toArray()[0];
		for(String s : freq.keySet()) {
			if(freq.get(s) > freq.get(mostCommon)) {
				mostCommon = s;
			}
		}
		return mostCommon;
	}

	//returns a count of how many times val occurs in the matrix
	private int countVals( String val )
	{
		int count = 0;
		for(int x = 0; x < grid.length; x++) 
			for(int y = 0; y < grid[0].length; y++) 
				if(grid[x][y].equals(val))
					count++;
		return count;
	}

	//display the grid
	public String toString()
	{
		String output="";
		for(String[] s : grid) {
			output += Arrays.toString(s) + "\n";
		}
		return output;
	}
}