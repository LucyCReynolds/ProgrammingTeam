import java.util.*;

public class ICPC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double m = in.nextLong();
        double n = in.nextLong();
        int t = in.nextInt();

        switch (t){
            case 1:
                double fact = 1;
                for(double i = n; i>0;i--){
                    fact *= i;
                    if(fact > m){
                        break;
                    }
                }
                if(fact <= m){
                    System.out.println("AC");
                }
                else {
                    System.out.println("TLE");
                }
                break;
            case 2:
                if(Math.pow(2,n) <= m){
                    System.out.println("AC");
                }
                else {
                    System.out.println("TLE");
                }
                break;
            case 3:
                if (Math.pow(n,4) <= m){
                    System.out.println("AC");
                }
                else {
                    System.out.println("TLE");
                }
                break;
            case 4:
                if (Math.pow(n,3) <= m){
                    System.out.println("AC");
                }
                else {
                    System.out.println("TLE");
                }
                break;
            case 5:
                if (Math.pow(n,2) <= m){
                    System.out.println("AC");
                }
                else {
                    System.out.println("TLE");
                }
                break;
            case 6:
                double top = Math.log10(n);
                double bot = Math.log10(2);
                double total = n*(top/bot);
                if(total <= m){
                    System.out.println("AC");
                }
                else {
                    System.out.println("TLE");
                }
                break;
            case 7:
                if(n<=m){
                    System.out.println("AC");
                }
                else {
                    System.out.println("TLE");
                }
                break;
            default:
                break;
        }
    }
}
