import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lucyreynolds on 4/25/15.
 */
public class Cousins {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        for (;;) {
            int nodes = in.nextInt();
            int target = in.nextInt();

            if (nodes == 0 && target == 0) {
                break;
            }

            ArrayList<Node> nodeList = new ArrayList<>();

            for (int i = 0; i < nodes; i++) {
                int cur = in.nextInt();
                nodeList.add(new Node(cur));
            }
            int p = 0;
            Node parent = nodeList.get(p);
            for (int j = 1; j < nodes-1; j++) {
                parent.children.add(nodeList.get(j));
                nodeList.get(j).parent = parent;
                if (nodeList.get(j + 1).name - nodeList.get(j).name > 1) {
                    parent = nodeList.get(++p);
                }
            }
            parent.children.add(nodeList.get(nodes-1));
            nodeList.get(nodes-1).parent = parent;

            int cousins = 0;
            Node targNode = nodeList.get(0);
            for (Node n : nodeList) {
                if (n.name == target) {
                    targNode = n;
                }
            }
            Node tParent = null;
            Node gParent = null;
            if (targNode.parent != null) {
                tParent = targNode.parent;
                if (tParent.parent != null) {
                    gParent = tParent.parent;

                    for (Node c : gParent.children) {
                        if (c != tParent) {
                            cousins += c.children.size();
                        }
                    }
                }
            }
            System.out.println(cousins);
        }
    }

    public static class Node{
        int name;
        Node parent;
        ArrayList<Node> children;

        public Node(int n){
            name = n;
            parent = null;
            children = new ArrayList<>();
        }
    }
}
