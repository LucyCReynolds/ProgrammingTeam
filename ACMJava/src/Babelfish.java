import java.util.*;

public class Babelfish {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String,String> dict = new HashMap<>();
        String input = in.nextLine();
        while(!input.equals("")){
            String[] split = input.split(" ");
            dict.put(split[1],split[0]);
            input = in.nextLine();
        }
        String word = "";
        while(in.hasNext()){
           word = in.next();
            if(dict.containsKey(word)){
                System.out.println(dict.get(word));
            }
            else
                System.out.println("eh");
        }
    }
}
