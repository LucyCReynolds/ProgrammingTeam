import java.io.*;
import java.util.*;
public class Army{
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());

		for(int i = 0; i < cases; i++){
			in.readLine();
			String input = in.readLine();

			String[] sizes = input.split(" ");
			int g = Integer.parseInt(sizes[0]);
			int m = Integer.parseInt(sizes[1]);

			ArrayList<Integer> gdz = new ArrayList<Integer>();
			ArrayList<Integer> mgdz = new ArrayList<Integer>();

			String[] god = in.readLine().split(" ");
			for(int k = 0; k < g; k++){
				gdz.add(Integer.parseInt(god[k]));
			}
			String[] mgod = in.readLine().split(" ");
			for(int l = 0; l < m; l++){
				mgdz.add(Integer.parseInt(mgod[l]));
			}

			Collections.sort(gdz);
			Collections.sort(mgdz);

			while(!gdz.isEmpty()&& !mgdz.isEmpty()){
				int gcur = gdz.get(0);
				int mcur = mgdz.get(0);
				if(gcur == mcur){
					mgdz.remove(0);
				}
				else if(gcur < mcur){
					gdz.remove(0);
				}
				else{
					mgdz.remove(0);
				}
			}
			if(gdz.isEmpty()){
				System.out.println("MechaGodzilla");
			}
			else if(mgdz.isEmpty()){
				System.out.println("Godzilla");
			}
			else{
				System.out.println("uncertain");
			}
		}
	}
}