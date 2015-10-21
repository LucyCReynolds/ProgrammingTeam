/**
 * Created by lucyreynolds on 4/12/15.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class WrongRight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (; ; ) {
            int b = in.nextInt();
            int n = in.nextInt();

            if (b == 0 || n == 0) {
                break;
            }

            ArrayList<pair> pairs = new ArrayList<>();

            for (int a = 0; a < 2 * b; a++) {
                for (int m = 1; m < 2 * n; m++) {
                    if(m-n != 0) {
                        if ((a / m) - (b / n) == (a - b) / (m - n)) {
                            pairs.add(new pair(a, m));
                        }
                    }
                }
            }

            for (int i = 0; i < pairs.size(); i++) {
                for (int j = 0; j < pairs.size() - 1; j++) {
                    if (move(pairs.get(i), pairs.get(i + 1))) {
                        pair temp = pairs.get(i);
                        pairs.set(i, pairs.get(i + 1));
                        pairs.add(i + 1, temp);
                    }
                }
            }

            for (pair p : pairs) {
                System.out.print(p.a + "/" + p.m);
            }
            System.out.print("\n");
        }
    }

    public static boolean move(pair a, pair b) {
        if (a.frac > b.frac) {
            return true;
        } else if (a.frac == b.frac) {
            if (b.a < a.a) {
                return true;
            }
        }
        return false;
    }

    public static class pair {
        int a;
        int m;
        double frac;

        pair(int A, int M) {
            a = A;
            m = M;
            frac = ((double) a) / m;
        }
    }
}
