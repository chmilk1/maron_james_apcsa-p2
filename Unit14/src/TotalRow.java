//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;

public class TotalRow
{
    public static int[] getRowTotals( int[][] m )
    {
    	int[] fin = new int[m.length];
    	for(int x = 0; x < m.length; x++) {
    		int count = 0;
    		for(int i : m[x]) {
    			count += i;
    		}
    		fin[x] = count;
    	}
    	//add code here
		return fin;
    }
}
