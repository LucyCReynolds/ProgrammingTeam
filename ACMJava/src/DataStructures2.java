import java.util.*;

public class DataStructures2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            boolean s = true, q = true, p = true;

            LinkedList<Integer> stack = new LinkedList<>();
            LinkedList<Integer> queue = new LinkedList<>();
            LinkedList<Integer> pqueue = new LinkedList<>();

            int n = in.nextInt();
            for(int i = 0; i < n; i++){
                int instruction = in.nextInt();
                int item = in.nextInt();
                if(instruction == 1){
                    stack.add(item);
                    queue.add(item);

                    for(int j = 0; j < pqueue.size(); j++){
                        if(pqueue.get(j) < item){
                            pqueue.add(j,item);
                            break;
                        }
                    }
                    if (pqueue.size() < queue.size()){
                        pqueue.add(item);
                    }
                }
                else {
                    if(stack.size() < 1 || stack.removeLast() != item){
                        s = false;
                    }
                    if(queue.size() < 1 || queue.removeFirst() != item){
                        q = false;
                    }
                    if(pqueue.size() < 1 || pqueue.removeFirst() != item){
                        p = false;
                    }
                }
            }
            if(!s && !q && !p){
                System.out.println("impossible");
            }
            else if ((s && q) || (s && p) || (q && p)){
                System.out.println("not sure");
            }
            else if (s){
                System.out.println("stack");
            }
            else if (q){
                System.out.println("queue");
            }
            else if (p){
                System.out.println("priority queue");
            }
        }
    }
}
