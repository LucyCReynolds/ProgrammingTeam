import java.util.*;

public class Bus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++) {
            int people = 0;
            int stops = in.nextInt();
            for(int j =0; j<stops;j++){
                people = (people*2)+1;
            }
            System.out.println(people);
        }
    }
}
