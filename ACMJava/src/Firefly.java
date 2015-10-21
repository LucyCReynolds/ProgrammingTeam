import java.util.Scanner;

/**
 * Created by lucyreynolds on 4/20/15.
 */
public class Firefly {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int flies = 1;
        for(;;){
            double range = in.nextInt();
            double x = in.nextInt();
            double y = in.nextInt();

            if(range == 0 && x == 0 && y == 0){
                break;
            }

            for(;;){
                double flyx = in.nextInt();
                double flyy = in.nextInt();

                if(flyx == -1 && flyy == -1){
                    System.out.println("Firefly " + flies++ + " not caught");
                    break;
                }
                double curDist = dist(flyx, x, flyy, y);
                x = (range/curDist) * (flyx-x) + x;
                y += (range/curDist) * (flyy-y);

                if(dist(flyx, x, flyy, y) <= 1){
                    System.out.println("Firefly " + flies++ + " caught at ("+ (int)flyx + "," + (int) flyy + ")");
                    int a = in.nextInt();
                    int b = in.nextInt();
                    while(a != -1 && b != -1){
                        a = in.nextInt();
                        b = in.nextInt();
                    }
                    break;
                }
            }
        }
    }

    public static double dist(double x1, double x2, double y1, double y2){
        double x = Math.pow((x2-x1),2.0);
        double y = Math.pow((y2-y1),2.0);

        return Math.sqrt(x+y);
    }
}
