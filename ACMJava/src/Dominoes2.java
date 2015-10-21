import java.util.*;

public class Dominoes2 {
    public static void main(String[] args) {
        Kattio in = new Kattio(System.in);
        int c = in.getInt();

        for(int i = 0; i < c; i++){
            int tiles = in.getInt();
            int lines = in.getInt();
            int hits = in.getInt();
            HashMap<Integer,Integer> nodes = new HashMap<>();

            for (int j = 0; j < lines; j++){
                nodes.put(in.getInt(),in.getInt());
            }
            int over = hits;
            for (int k = 0; k < hits; k++){
                int cur = in.getInt();
                while (true) {
                    if(!nodes.containsKey(cur)){
                        break;
                    }
                    cur = nodes.get(cur);
                    over++;

                }
            }
            System.out.println(over);
        }
    }
}
