import java.util.*;

public class Helio {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = 1;
        while (in.hasNext()){
            int e = in.nextInt();
            int m = in.nextInt();
            int d = 0;
            for(; ; d++) {
                if (e == 0 && m == 0) {
                    break;
                }
                e++;
                m++;
                if(e == 365){
                    e = 0;
                }
                if(m == 687){
                    m=0;
                }
            }
            System.out.printf("Case %d: %d%n",c,d);
            c++;
        }
    }
}
