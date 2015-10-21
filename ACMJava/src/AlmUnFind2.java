import java.util.*;

public class AlmUnFind2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<TreeSet<Integer>> sets = new ArrayList<TreeSet<Integer>>();
            int[] loc = new int[n+1];
            sets.add(0, null);
            for (int i = 1; i <= n; i++) {
                loc[i] = i;
                sets.add(i,new TreeSet<Integer>());
                sets.get(i).add(i);
            }
            for (int i = 0; i < m; i++) {
                int com = in.nextInt();
                switch (com){
                    case 1:
                        int p = in.nextInt();
                        int q = in.nextInt();
                        if(!(loc[q] == loc[p])){
                            sets.get(loc[p]).addAll(sets.get(loc[q]));
                            loc[q] = loc[p];
                            sets.get(q).clear();
                        }
                        break;
                    case 2:
                        int y = in.nextInt();
                        int x = in.nextInt();
                        if(!(loc[x] == loc[y])){
                            sets.get(loc[y]).remove(y);
                            sets.get(loc[x]).add(y);
                            loc[y] = loc[x];
                        }
                        break;
                    case 3:
                        int b = in.nextInt();
                        Set s = sets.get(loc[b]);
                        int sum = 0;
                        for (Object z: s){
                            sum += (Integer)z;
                        }
                        System.out.println(s.size() + " " + sum);
                }
            }
        }
    }
}
