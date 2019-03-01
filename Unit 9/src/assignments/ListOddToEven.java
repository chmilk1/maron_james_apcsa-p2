package assignments;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOddToEven
{
	public static int go( List<Integer> ray )
	{
		int odd = -1;
		int even = -1;
		for(int i = 0; i < ray.size(); i++) {
			if(ray.get(i) % 2 == 1 && odd < 0) {
				odd = i;
			} else if(ray.get(i) % 2 == 0 && odd > -1) {
				even = i;
			}
		}
		return odd == -1 || even == -1 ? -1 : Math.abs(even - odd);
		/* Basically just:
		 * if(odd == -1 || even == -1){
		 * 	return -1;
		 * } else {
		 * 	return Math.abs(even - odd);
		 * }
		 */
	}
	
	//Very usefull method (was not aware of Arrays.asList()):
	//converting primitive type arrays in to boxed Integer Lists(the int[] are easer to implement)
	public static List<Integer> box(int[] ints) {
		List<Integer> list = new ArrayList<>();
		list.addAll( Arrays.stream(ints).boxed().collect(Collectors.toList()));
		return list;		
	}
}