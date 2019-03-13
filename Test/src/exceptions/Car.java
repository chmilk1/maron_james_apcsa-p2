package exceptions;

public class Car extends Vehicle implements Wheel, Engine{

	boolean atDealearShip = false;
	
	@Override
	public void fixEngine() {
		if(atDealearShip) {
			System.out.println("all done!");
		} else {
			System.out.println("no chance");
		}
		
	}

	@Override
	public void changeTire() {
		System.out.println("zzzzzzzzzzzzzzz");
		
	}

	@Override
	void go() {
		System.out.println("Zoom");
		
	}

}
