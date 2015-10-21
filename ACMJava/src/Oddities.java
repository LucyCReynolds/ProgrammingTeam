import java.util.*;

public class Oddities {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int k = 0; k <n; k++){
            int j = in.nextInt();
            if(j%2 == 0){
                System.out.println(j + " is even");
            }
            else {
                System.out.println(j + " is odd");
            }
        }
    }
}
