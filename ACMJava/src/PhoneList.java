import java.util.*;
public class PhoneList{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int cases = in.nextInt();
		for(int i = 0; i < cases; i++){
			String answer = "YES";
			int n = in.nextInt();
			in.nextLine();
			Node head = new Node(' ', false);
			for(int j = 0; j < n; j++){
				Node node = head;
				char[] s = in.nextLine().toCharArray();
				for(int k = 0; k < s.length; k++){
					if (node.getChild(s[k]) != null){
						node = node.getChild(s[k]);
						if (node.word == true){
							answer = "NO";
						}
					}
					else {
						node.children.add(new Node(s[k],false));
						node = node.getChild(s[k]);
					}
				}
				if(node.children.size() != 0){
					answer = "NO";
				}
				node.word = true;
			}
			System.out.println(answer);
		}
	}

	public static class Node{
		char a;
		boolean word;
		ArrayList<Node> children;

		public Node(char c, boolean w){
			a = c;
			word = w;
			children = new ArrayList<Node>();
		}

		public Node getChild(char c){
			for(Node n: children){
				if(n.a == c){
					return n;
				}
			}
			return null;
		}

	}
}