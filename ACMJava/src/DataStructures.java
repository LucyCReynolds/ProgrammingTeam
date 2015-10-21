import java.util.*;

public class DataStructures {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            boolean queue = false, stack = false, priority = true;
            int lines = in.nextInt();
            ArrayList<Integer> ins = new ArrayList<Integer>();
            ArrayList<Integer> outs = new ArrayList<Integer>();

            for(int i = 0; i < lines; i++){
                if (in.nextInt() == 1){
                    ins.add(in.nextInt());
                }
                else {
                    outs.add(in.nextInt());
                }
            }

            if(ins.equals(outs)){
                queue = true;
            }

            ArrayList<Integer> rev = ins;
            Collections.reverse(rev);
            if(rev.equals(outs)){
                stack = true;
            }

            ArrayList<Integer> sort = ins;
            Collections.sort(sort);
            Collections.reverse(sort);
            int length = outs.size();
            for (int j = 0; j < length; j++){
                if(sort.size() >= j+1) {
                    if (!Objects.equals(sort.get(j), outs.get(j))) {
                        priority = false;
                    }
                }
                else{
                    priority = false;
                }
            }

            if(!stack && !queue && !priority){
                System.out.println("impossible");
            }
            else if ((stack && queue) || (stack && priority) || (queue && priority)){
                System.out.println("not sure");
            }
            else if (stack){
                System.out.println("stack");
            }
            else if (queue){
                System.out.println("queue");
            }
            else if (priority){
                System.out.println("priority queue");
            }
        }
    }
}
