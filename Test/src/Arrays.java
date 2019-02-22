import java.util.stream.Collectors;

public class Arrays {
	public static void main(String[] args) {
		int[] test = {1,2,3,4,5};
		int length = (int) java.util.Arrays.stream(test).filter(i -> i % 2 == 0).count();
		
	}
}
