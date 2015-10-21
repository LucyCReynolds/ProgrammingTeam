import java.util.*;

public class Symmetric {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int set = 1;
        for(;;){
            int n = in.nextInt();
            if(n == 0){
                break;
            }
            ArrayList<String> names = new ArrayList<>();
            for (int i = 0; i < n; i++){
                names.add(in.next());
            }
            int s = names.size();
            ArrayList<String> order = new ArrayList<>();
            for(int i = 0; i < s; i+=2){
                order.add(names.get(i));
            }
            ArrayList<String> back = new ArrayList<>();
            for (int j = 1; j <s; j+=2){
                back.add(names.get(j));
            }
            Collections.reverse(back);
            order.addAll(back);
            System.out.println("SET " + set);
            for (String b: order){
                System.out.println(b);
            }
            set++;
        }
    }
}
