import java.util.*;
import java.text.*;

public class ReverseRoot{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		LinkedList<String> ll = new LinkedList<String>();
		DecimalFormat df = new DecimalFormat("0.0000");


		while(in.hasNextLong()){
			double d = Math.sqrt((double)in.nextLong());
			ll.add(df.format(d));
		}

		while(!ll.isEmpty()){
			System.out.println(ll.removeLast());
		}
	}
}