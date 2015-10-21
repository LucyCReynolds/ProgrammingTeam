import java.util.*;
import java.lang.*;
public class Ragged{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		ArrayList<String> input = new ArrayList<String>();
		while(in.hasNextLine()){
			input.add(in.nextLine());
		}

		int max = 0;
		for(String s: input){
			if (s.length() > max){
				max = s.length();
			}
		}
		double rag = 0;
		double cur = 0;
		input.remove(input.size()-1);
		for(String x: input){
			cur = x.length();
			rag += Math.pow((max-cur),2);
		}

		System.out.println((int)rag);
	}
}