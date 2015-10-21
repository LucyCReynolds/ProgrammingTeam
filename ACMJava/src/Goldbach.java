import java.util.*;
public class Goldbach {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        final ArrayList<Integer> PRIMES = erSieve(32000);

        int c = in.nextInt();
        for(int i = 0; i < c; i++){
            ArrayList<Pair> results = new ArrayList<>();
            int n = in.nextInt();
            int k = 0;
            while(PRIMES.get(k) <= n/2){
                int s = n-PRIMES.get(k);
                int o = Collections.binarySearch(PRIMES,s);
                if(o >= 0){
                    results.add(new Pair(PRIMES.get(k),s));
                }
                k++;
            }
            System.out.printf("%d has %d representation(s)%n",n,results.size());
            for(Pair p: results){
                System.out.printf("%d+%d%n", p.x,p.y);
            }
            System.out.println();
        }
    }
    public static ArrayList<Integer> erSieve(int up){
        ArrayList<Integer> primes = new ArrayList<>();
        int upSqr = (int)Math.sqrt(up);
        boolean[] comp = new boolean[up+1];
        for(int m = 2; m <= upSqr; m++){
            if(!comp[m]){
                for(int k = m*m; k<= up; k+=m){
                    comp[k] = true;
                }
            }
        }
        for(int n = 2; n < up+1; n++){
            if(!comp[n]){
                primes.add(n);
            }
        }
        Collections.sort(primes);
        return primes;
    }
    public static class Pair{
        int x;
        int y;
        public Pair(int a, int b){
            x = a;
            y = b;
        }
    }
}
