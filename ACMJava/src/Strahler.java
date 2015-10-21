import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by lucyreynolds on 4/23/15.
 */
public class Strahler {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int sets = in.nextInt();

        for(int i = 0; i < sets; i++){
            int setNum = in.nextInt();
            int nodes = in.nextInt();
            int edges = in.nextInt();

            ArrayList<Node> nodeList = new ArrayList<>(nodes+1);
            Stack<Node> search = new Stack<>();
            nodeList.add(0,null);
            for (int j = 1; j <= nodes; j++){
                nodeList.add(j,new Node());
            }

            for(int k = 0; k < edges; k++){
                int p = in.nextInt();
                int c = in.nextInt();

                nodeList.get(c).parents.add(nodeList.get(p));

            }

            for (int m = 1; m <= nodes; m++){
                if(nodeList.get(m).parents.size() == 0){
                    nodeList.get(m).order = 1;
                    nodeList.get(m).ordered = true;
                }
            }

            search.push(nodeList.get(nodes));
            while (search.size() > 0){
                Node n = search.pop();
                if(!checkParents(n)){
                    search.push(n);
                    for (Node p: n.parents){
                        search.push(p);
                    }
                }
            }

            System.out.println(setNum + " " + nodeList.get(nodes).order);

        }
    }

    public static class Node{
        int order;
        boolean ordered;
        ArrayList<Node> parents;

        public Node() {
            ordered = false;
            parents = new ArrayList<Node>();
            int order = 0;
        }
    }

    public static class Edge{
        int parent;
        int child;

        public Edge(int p, int c){
            parent = p;
            child = c;
        }
    }

    public static boolean checkParents(Node n){
        if (n.ordered){
            return true;
        }
        int max = 0;
        for (Node p: n.parents){
            if(!p.ordered){
                return false;
            }
            else if (p.order > max){
                max = p.order;
            }
        }

        int num = 0;
        n.ordered = true;
        for (Node q: n.parents){
            if (q.order == max){
                num++;
            }
        }

        if (num > 1){
            n.order = max+1;
            return true;
        }
        n.order = max;
        return true;
    }

}
