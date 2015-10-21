/*
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.*;

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

public class IntList {
    public static void main(String[] args) {
        Kattio in = new Kattio(System.in, System.out);
        int t = in.getInt();
        for (int i = 0; i < t; i++) {
            char[] inst = in.getWord().toCharArray();
            int n = in.getInt();
            boolean reversed = false;
            String line = in.getWord().replace(',', ' ');
            int l = line.length();
            line = line.substring(1,l-1);
            String[] list = line.split(" ");
            LinkedList<String> nums = new LinkedList<>(Arrays.asList(list));
            String result = "";
            for (char c : inst) {
                if (c == 'R') {
                    reversed = !reversed;
                }
                else {
                    if(n ==0){
                        result = "error";
                        break;
                    }
                    if(reversed){
                        n--;
                        nums.removeLast();
                    }
                    else {
                        n--;
                        nums.removeFirst();
                    }
                }
            }
            if(result.equals("error")){
                System.out.println(result);
            }
            else {
                if (reversed) {
                    Collections.reverse(nums);
                }
                System.out.println(nums.toString().replaceAll(" ", ""));
            }

        }
    }
}
*/
