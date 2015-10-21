import java.util.*;
public class Weights{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for (int i = 0; i < cases; i++){
			int weight = in.nextInt();
			ArrayList<Integer> right = new ArrayList<Integer>();
			ArrayList<Integer> left = new ArrayList<Integer>();

			int sec = 0;
			int k = 0;
			for(;;){
				sec += Math.pow(3,k);
				if (sec >= weight){
					break;
				}
				k++;
			}
			int sum = (int)Math.pow(3,k);
			right.add(sum);
			while(sum != weight){
				if(sum < weight){
					for (int l = 0; true; l++){
						if(Math.pow(3,l) >= (weight-sum)){
							sum += (int)Math.pow(3,l);
							right.add((int)Math.pow(3,l));
							break;
						}
					}
				}
				else if(sum > weight){
					for(int m = 0; m <100; m++){
						if (Math.pow(3,m) >= (sum - weight)){
							sum -= (int)Math.pow(3,m);
							left.add((int)Math.pow(3,m));
							break;
						}
					}
				}
			}

			System.out.print("left pan:");
			for(Integer y: left){
				System.out.print(" " + y);
			}
			System.out.printf("\nright pan:");
			for (Integer z: right){
				System.out.print(" " + z);
			}
			if(i < cases-1){
				System.out.println();
				System.out.println();
			}
		}
	}
}