import java.util.*;
public class Bishops{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		while(in.hasNextInt()){
			int i = in.nextInt();
			int result = 0;
			if(i == 0){
				result = 0;
			}
			else if(i == 1){
				result = 1;
			}
			else{
				result = i;
				result += (i-2);
			}	
			System.out.println(result);
		}
	}
}