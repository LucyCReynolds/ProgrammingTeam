import java.util.*;

public class PizzaHawaii {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int p =  in.nextInt();
            TreeMap<String, ArrayList<Integer>> foring = new TreeMap<>();
            TreeMap<String, ArrayList<Integer>> enging = new TreeMap<>();

            for (int j = 0; j < p; j++) {
                in.next();
                int n = in.nextInt();
                for (int k = 0; k < n; k++) {
                    String s = in.next();
                    if(foring.containsKey(s)){
                        foring.get(s).add(j);
                    }
                    else{
                        foring.put(s,new ArrayList<Integer>());
                        foring.get(s).add(j);
                    }
                }
                int m = in.nextInt();
                for (int k = 0; k < m; k++) {
                    String s = in.next();
                    if(enging.containsKey(s)){
                        enging.get(s).add(j);
                    }
                    else{
                        enging.put(s,new ArrayList<Integer>());
                        enging.get(s).add(j);
                    }
                }
            }

            for (String s: foring.keySet()) {
                for (String w: enging.keySet()) {
                    if(foring.get(s).equals(enging.get(w))){
                        System.out.println("(" + s + ", " + w + ")");
                    }
                }
            }
            if(i != t-1) {
                System.out.println();
            }
        }
    }

}
