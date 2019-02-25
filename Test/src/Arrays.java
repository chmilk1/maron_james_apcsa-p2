import java.util.stream.Collectors;

public class Arrays {
	public static void main(String[] args) {
		int[] test = {1,2,3,4,5};
		int length = (int) java.util.Arrays.stream(test).filter(i -> i % 2 == 0).count();
		
		int f=12, g=14;
		if(((f>4) ||(++g>16)) && f>0) {
		   System.out.println("dog");
		}
		System.out.println(g);
		
		int h=12, i=15;
		if(h<4 ||++i>15 && h>8)   
		{
		   System.out.println("cat");
		}
		System.out.println(i);

		
		
	}
}
