import java.util.*;

public class Candies {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();

        for (int i = 0; i < cases; i++){
            int n = in.nextInt();
            long sum = 0;
            for (long j = 0; j < n; j++){
                sum += in.nextLong()%n;
            }
            
            if(sum%n == 0){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
