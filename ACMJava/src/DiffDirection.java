import java.text.DecimalFormat;
import java.util.*;
public class DiffDirection {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("########.####");
        for(;;){
            int n = in.nextInt();
            in.nextLine();
            if(n == 0){
                break;
            }
            ArrayList<Pair> pairs = new ArrayList<>();
            for(int i = 0; i < n; i++){
                Scanner cur = new Scanner(in.nextLine());
                float startx = cur.nextFloat();
                float starty = cur.nextFloat();
                cur.next();
                double angle = cur.nextDouble();
                cur.next();
                double dist = cur.nextDouble();
                startx = startx + (float)(dist*Math.cos(Math.toRadians(angle)));
                starty = starty + (float)(dist*Math.sin(Math.toRadians(angle)));
                while(cur.hasNext()){
                    String test = cur.next();
                    if(Objects.equals(test, "turn")){
                        angle += cur.nextDouble();
                    }
                    else if(Objects.equals(test, "walk")){
                        double d = cur.nextDouble();
                        startx += (d*Math.cos(Math.toRadians(angle)));
                        starty += (d*Math.sin(Math.toRadians(angle)));
                    }
                }
                pairs.add(new Pair(startx,starty));
            }
            float avgx = 0;
            float avgy = 0;
            for(Pair p: pairs){
                avgx += p.x;
                avgy += p.y;
            }
            avgx /= n;
            avgy /= n;

            float max = Float.MIN_VALUE;

            for(Pair p: pairs){
                if(dist(avgx,avgy,p) > max){
                    max = dist(avgx,avgy,p);
                }
            }

            String axs = df.format(avgx);
            String ays = df.format(avgy);
            String ms = df.format(max);

            System.out.println(axs + " " + ays + " " + ms);

        }
    }
    public static class Pair{
        float x;
        float y;
        Pair(float _x, float _y){
            x = _x;
            y = _y;
        }

    }
    public static float dist(float x, float y, Pair p){
        float xch = Math.abs(x-p.x);
        float ych = Math.abs(y-p.y);
        return ((float)Math.sqrt(Math.pow(xch,2)+Math.pow(ych,2)));
    }
}
