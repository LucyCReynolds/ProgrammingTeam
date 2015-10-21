import java.util.*;

public class Perket {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ing = in.nextInt();
        ArrayList<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < ing; i++) {
            pairs.add(new Pair(in.nextInt(),in.nextInt()));
        }

    }
    public static class Pair{
        int s;
        int b;
        public Pair(int xs, int xb){
            s = xs;
            b = xb;
        }
    }
}
