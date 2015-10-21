import java.util.*;
public class EngEng {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeSet<String> words = new TreeSet<>();
        while(in.hasNext()){
            String[] line = in.nextLine().split(" ");
            String result = "";
            for(String s: line){
                if(words.contains(s.toLowerCase())){
                    s = ".";
                }
                words.add(s.toLowerCase());
                result+= s + " ";
            }
            System.out.println(result.substring(0,result.length()-1));
        }
    }
}
