import java.util.*;
public class Compound {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> start = new ArrayList<>();
        while(in.hasNext()){
            start.add(in.next());
        }
        for(int i = 0;i<start.size();i++){
            for(int j = 0; j < start.size(); j++){
                if(!start.get(i).equals(start.get(j))){
                    String n = start.get(i)+start.get(j);
                    if(!words.contains(n)){
                        words.add(n);
                    }
                }
            }
        }
        Collections.sort(words);
        for(String s: words){
            System.out.println(s);
        }
    }
}
