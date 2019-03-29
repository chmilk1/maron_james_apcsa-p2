import java.awt.Graphics;

public abstract class Entity implements Locatable, Comparable<Entity> {
	private int x;
	private int y;
	private int z;
	
	private double xVel;
	private double yVel;
	private double zVel;
	
	private double xAcl;
	private double yAcl;
	private double zAcl;

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

	public Entity(int x, int y, int z, double xVel, double yVel, double zVel, double xAcl, double yAcl, double zAcl) {
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
		
		setX((int)(x+xVel));
		setY((int)(y+yVel));
		setZ((int)(z+zVel));
	}

	public double getxVel() {
		return xVel;
	}

	public void setxVel(double d) {
		this.xVel = d;
	}

	public double getyVel() {
		return yVel;
	}

	public void setyVel(double yVel) {
		this.yVel = yVel;
	}

	public double getzVel() {
		return zVel;
	}

	public void setzVel(double zVel) {
		this.zVel = zVel;
	}

	public double getxAcl() {
		return xAcl;
	}

	public void setxAcl(double xAcl) {
		this.xAcl = xAcl;
	}

	public double getyAcl() {
		return yAcl;
	}

	public void setyAcl(double yAcl) {
		this.yAcl = yAcl;
	}

	public double getzAcl() {
		return zAcl;
	}

	public void setzAcl(double zAcl) {
		this.zAcl = zAcl;
	}
}
