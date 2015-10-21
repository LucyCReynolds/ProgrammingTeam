import java.util.*;
public class Stat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = 1;
        while (in.hasNext()){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int num = in.nextInt();
            ArrayList<Integer> line = new ArrayList<>();
            for(int i = 0; i < num; i++){
                line.add(in.nextInt());
            }
            for(Integer s: line){
                if(s > max){
                    max = s;
                }
                if(s < min){
                    min = s;
                }
            }
            System.out.printf("Case %d: %d %d %d%n", c,min,max,max-min);
            c++;
        }
    }
}
