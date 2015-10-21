import java.util.*;

public class Doors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        HashMap<String,Boolean> people =  new HashMap<>();
        while(in.hasNext()){
            String[] move = in.nextLine().split(" ");
            String name = move[1];
            String x = move[0];
            if(people.containsKey(name)){
                boolean isIn = people.get(name);
                if(Objects.equals(x, "entry")){
                    if(isIn){
                        System.out.println(name + " entered (ANOMALY)");
                    }
                    else {
                        System.out.println(name + " entered");
                    }
                    people.put(name, true);
                }
                else {
                    if(!isIn){
                        System.out.println(name + " exited (ANOMALY)");
                    }
                    else {
                        System.out.println(name + " exited");
                    }
                    people.put(name, false);
                }
            }
            else {
                if(Objects.equals(x, "entry")){
                    System.out.println(name + " entered");
                    people.put(name, true);
                }
                else {
                    System.out.println(name + " exited (ANOMALY)");
                    people.put(name,false);
                }
            }

        }
    }
}
