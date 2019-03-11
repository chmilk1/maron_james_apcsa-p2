
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Maron

public class Skeleton implements Monster {
	private String name;
	private int size;

	public Skeleton() {
		this.size = 1;
		this.name = "default";
	}
	
	public Skeleton(int size, String name) {
		this.size = size;
		this.name = name;
	}

	@Override
	public int getHowBig() {
		return size;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isBigger(Monster other) {
		return other.getHowBig() < getHowBig();
	}

	@Override
	public boolean isSmaller(Monster other) {
		return other.getHowBig() < getHowBig();
	}

	@Override
	public boolean namesTheSame(Monster other) {
		return other.getName().toLowerCase().equals(getName().toLowerCase());
	}

	@Override
	public String toString() {
		return getName() + " " + getHowBig();
	}

}