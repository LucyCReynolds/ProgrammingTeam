import java.util.*;
import java.util.regex.Pattern;

public class Zipf {
    public static void main(String[] args) {
        Kattio in = new Kattio(System.in);
        Pattern p = Pattern.compile("\\p{Punct}");
        while (in.hasMoreTokens()){
            int n = in.getInt();
            boolean has = false;
            TreeMap<String,Integer> map = new TreeMap<>();
            for (;;){
                String cur = in.getWord();
                cur = p.matcher(cur).replaceAll("");
                if(cur.equals("EndOfText")){
                    break;
                }
                if(!cur.equals("")) {
                    cur = cur.toLowerCase();
                    if (map.containsKey(cur)) {
                        map.put(cur, map.get(cur) + 1);
                    } else {
                        map.put(cur, 1);
                    }
                }
            }
            for (Map.Entry<String,Integer> e: map.entrySet()){
                if(e.getValue() == n){
                    System.out.println(e.getKey());
                    has = true;
                }
            }
            if(!has){
                System.out.println("There is no such word.");
            }
            if(in.hasMoreTokens()){
                System.out.println();
            }
        }
    }
}
