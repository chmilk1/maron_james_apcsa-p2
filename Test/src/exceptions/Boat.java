package exceptions;

public class Boat extends Vehicle implements Engine{

	int hullSuze;
	@Override
	public void fixEngine() {
		System.out.println("get the tool box");
		
	}

	@Override
	void go() {
		System.out.println("*water splashing*");
		
	}

}
