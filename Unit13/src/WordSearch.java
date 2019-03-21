//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;
import java.io.*; 

public class WordSearch
{
    private String[][] m;

    public WordSearch( int size, String str )
    {
    	m = new String[size][size];
    	if(str.length() % size != 0) {
    		System.out.println(str.length() % size);
    		throw new IllegalArgumentException();
    	}
    	for(int line = 0; line < str.length()/size; line++) {
    		char[] area = str.substring(line*size, (line+1)*size).toCharArray();
    		for(int spot = 0; spot < area.length; spot++) {
    			m[line][spot] = "" + area[spot];
    		}
    	}
    }

    public boolean isFound( String word )
    {
    	for(int x = 0; x < m.length; x++) {
    		if(getColum(x).contains(word)) {
    			return true;
    		}
    		if(getDiag(x,m[0].length-1).contains(new StringBuffer(word).reverse().toString())) {
    			return true;
    		}
    	}
    	
    	for(int y = 0; y < m.length; y++) {
    		if(getColum(y).contains(word)) {
    			return true;
    		}
    		if(getDiag(m.length-1,y).contains(new StringBuffer(word).reverse().toString())) {
    			return true;
    		}
    	}
    	
    	return false;
    }

	public String getRow(int y) {
		String row = "";
		for(int x = 0; x < m.length; x++) {
			row += m[x][y];
		}
		return row;
	}
	public String getColum(int x) {
		String colum = "";
		for(int y = 0; y < m[0].length; y++) {
			colum += m[x][y];
		}
		return colum;
	}
	public String getDiag(int x, int y) {
		String diag = "";
		while(x > 0 && y > 0) {
			diag += m[x][y];
			x--;
			y--;
		}
		return diag;
	}

    public String toString()
    {
 		return "";
    }
}
