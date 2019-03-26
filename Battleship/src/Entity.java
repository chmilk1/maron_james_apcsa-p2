import java.awt.Graphics;

public abstract class Entity implements Locatable, Comparable<Entity> {
	private int x;
	private int y;
	private int z;
	
	private int xVel;
	private int yVel;
	private int zVel;
	
	private int xAcl;
	private int yAcl;
	private int zAcl;

	public Entity() {
		this.x=0;
		this.y=0;
		this.z=0;
		this.xVel=0;
		this.yVel=0;
		this.zVel=0;
		this.xAcl=0;
		this.yAcl=0;
		this.zAcl=0;
	}
	
	public Entity(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Entity(int x, int y, int z, int xVel, int yVel, int zVel, int xAcl, int yAcl, int zAcl) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.xVel = xVel;
		this.yVel = yVel;
		this.zVel = zVel;
		this.xAcl = xAcl;
		this.yAcl = yAcl;
		this.zAcl = zAcl;
	}

	@Override
	public void setPos(int x, int y, int z) {
		setX(x);
		setY(y);
		setZ(z);
	}

	@Override
	public void setX(int x) { this.x = x; }

	@Override
	public void setY(int y) { this.y = y; }

	@Override
	public void setZ(int z) { this.z = z; }

	@Override
	public int getX() { return x; }

	@Override
	public int getY() { return y; }

	@Override
	public int getZ() { return z; }
	
	public abstract void draw(Graphics window);
	
	public void update(Game game) {
		setxVel(xVel+xAcl);
		setyVel(yVel+yAcl);
		setzVel(zVel+zAcl);
		
		setX(x+xVel);
		setY(y+yVel);
		setZ(z+zVel);
	}

	public int getxVel() {
		return xVel;
	}

	public void setxVel(int xVel) {
		this.xVel = xVel;
	}

	public int getyVel() {
		return yVel;
	}

	public void setyVel(int yVel) {
		this.yVel = yVel;
	}

	public int getzVel() {
		return zVel;
	}

	public void setzVel(int zVel) {
		this.zVel = zVel;
	}

	public int getxAcl() {
		return xAcl;
	}

	public void setxAcl(int xAcl) {
		this.xAcl = xAcl;
	}

	public int getyAcl() {
		return yAcl;
	}

	public void setyAcl(int yAcl) {
		this.yAcl = yAcl;
	}

	public int getzAcl() {
		return zAcl;
	}

	public void setzAcl(int zAcl) {
		this.zAcl = zAcl;
	}
}
