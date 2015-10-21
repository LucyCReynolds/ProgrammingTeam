import java.util.*;

public class Spread {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i  = 0; i < n; i++){
            int sum = in.nextInt();
            boolean found = false;
            int diff = in.nextInt();
            for(int j = 0; j <= sum; j++){
                int score = sum - j;
                if (Math.abs(j-score) == diff){
                    System.out.println(Math.max(score,j)+ " "+ Math.min(score,j));
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("impossible");
            }
        }
    }
}
