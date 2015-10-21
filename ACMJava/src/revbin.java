import java.io.*;
import java.util.*;
import java.lang.*;
public class revbin{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);		
		int  input = in.nextInt();
		String bin = Integer.toBinaryString(input);
		StringBuilder rev = new StringBuilder(bin);
		rev = rev.reverse();
		Integer out = Integer.parseInt(rev.toString(),2);
		out = out.intValue();
		System.out.println(out);
	}
}