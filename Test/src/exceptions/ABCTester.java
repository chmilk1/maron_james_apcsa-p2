package exceptions;

public class ABCTester {
	
public static void main(String[] args) {
	A a = new A();
	B b = new B();
	
	a.hello();
	b.hello();
	System.out.println(a.toString());
}
}
