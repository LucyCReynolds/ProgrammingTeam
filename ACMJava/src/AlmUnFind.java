import java.util.*;

public class AlmUnFind {

    public static class QuickUnion
    {
        private int[] id;
        public QuickUnion(int N)
        {
            id = new int[N];
            for (int i = 0; i < N; i++) id[i] = i;
        }
        public int root(int i)
        {
            while (i != id[i])
            {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
        public boolean find(int p, int q)
        {
            return root(p) == root(q);
        }
        public void unite(int p, int q)
        {
            int i = root(p);
            int j = root(q);
            id[i] = j;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            QuickUnion qu = new QuickUnion(n);
            for (int i = 0; i < m; i++) {
                int op = in.nextInt();
                switch (op){
                    case 1:
                        int p = in.nextInt();
                        int q = in.nextInt();
                        if(!qu.find(p, q)) {
                            qu.unite(p, q);
                        }
                        break;
                    case 2:
                        int x = in.nextInt();
                        int y = in.nextInt();
                        if(!qu.find(x,y)){

                        }
                }
            }
        }
    }

}
