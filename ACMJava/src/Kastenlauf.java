/*
import java.util.*;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
public class Kastenlauf {
    int[] nodes;
    public static void main(String[] args) {
        Kattio in = new Kattio(System.in);
        int test = in.getInt();
        for(int i = 0; i < test; i++){
            int lines = in.getInt();
            int[] set = new int[lines+2];
            Node start = new Node(in.getInt(),in.getInt());
            nodes.add(start);
            set[0] = 0;
            for (int j = 1; j <= lines; j++) {
                Node n = new Node(in.getInt(),in.getInt());
                nodes.add(n);
                set[j] = j;
            }
            Node end = new Node(in.getInt(),in.getInt());
            nodes.add(end);
            set[lines+1] = lines+1;

            for (int j = 0; j < nodes.size(); j++) {
                Node a = nodes[j];
                for (int k = j+1; k < nodes.size(); k++) {
                    Node b = nodes.get(k);
                    if(Math.abs(b.x-a.x) + Math.abs(b.y-a.y) <= 1000){
                        union(j,k);
                    }
                }
            }

            if(set[0] == set[lines+1]){
                System.out.println("happy");
            }
            else {
                System.out.println("sad");
            }
        }
    }
    public static class Node{
        int x;
        int y;
        public Node(int n, int m){
            x = n;
            y = m;
        }
    }
    public static int find(int x){
        int n = nodes[x];
        if(n == x){
            return x;
        }
        else {
            return nodes[x] = find(n);
        }
    }
    public static void union(int i, int j){
        int root1 = find(i);
        int root2 = find(j);

        if(root1 == root2){
            return;
        }
        else{
            nodes[root1] = root2;
        }
    }
}
*/
