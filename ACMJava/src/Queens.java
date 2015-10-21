import java.util.*;

public class Queens {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Queen> queens = new ArrayList<>();
        TreeSet<Integer> rows = new TreeSet<>();
        TreeSet<Integer> cols = new TreeSet<>();
        for(int i = 0; i < 8; i++){
            char[] line = in.nextLine().toCharArray();
            for(int j = 0; j < 8; j++){
                if(line[j] == '*'){
                    queens.add(new Queen(j,i));
                    if(rows.contains(j) || cols.contains(i)) {
                        System.out.println("invalid");
                        return;
                    }
                    rows.add(j);
                    cols.add(i);
                }
            }
        }
        if(queens.size() != 8){
            System.out.println("invalid");
            return;
        }
        for(int j = 0; j < 8; j++){
            Queen q = queens.get(j);
            for(int k = j+1; k < 8; k++){
                Queen p = queens.get(k);
                if(Math.abs(p.row-q.row) == Math.abs(p.col - q.col)){
                    System.out.println("invalid");
                    return;
                }
            }
        }
        System.out.println("valid");

    }
    public static class Queen{
        int row;
        int col;
        public Queen(int r, int c){
            row = r;
            col = c;
        }
    }
}
