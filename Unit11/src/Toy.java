//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Toy
{
	private String name;
	private int count;

	public Toy()
	{
		setName("toy");
		setCount(0);
	}

	public Toy( String nm )
	{
		setName(nm);
		setCount((int) (Math.random()*1000));
	}
	
	public Toy( String nm, int cnt )
	{
		setName(nm);
		setCount(cnt);
	}
	
	public int getCount()
	{
		return this.count;
	}
	
	public void setCount( int cnt )
	{
		this.count = cnt;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName( String nm )
	{
		this.name = nm;
	}

	public String toString()
	{
	   return name + " " + count;
	}
}