import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FunHouse {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[][] dirs = {{0,-1}, {1,0}, {0,1}, {-1,0}};
        final int U = 0, R = 1, D = 2, L = 3;
        int c = 1;
        for(;;) {
            String[] nums = in.readLine().split(" ");
            int w = Integer.parseInt(nums[0]);
            int l = Integer.parseInt(nums[1]);
            if (w == 0 && l == 0){
                break;
            }
            int x = -1;
            int y = -1;
            char[][] board = new char[l][w];

            for (int i = 0; i < l; i++) {
                board[i] = in.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    if (board[i][j] == '*'){
                        x = j;
                        y = i;
                    }
                }
            }
            int dir=-1;
            if(x == 0){
                dir = R;
            }
            else if(y == 0){
                dir = D;
            }
            else if(x == w-1){
                dir = L;
            }
            else if(y == l-1){
                dir = U;
            }

            x += dirs[dir][0];
            y += dirs[dir][1];

            char cur = board[y][x];
            for(;cur !='x';) {
                switch (cur) {
                    case '.':
                        x += dirs[dir][0];
                        y += dirs[dir][1];
                        break;
                    case '/':
                        switch (dir){
                            case R :
                                dir = U;
                                break;
                            case L :
                                dir = D;
                                break;
                            case U :
                                dir = R;
                                break;
                            case D :
                                dir = L;
                                break;
                        }
                        x += dirs[dir][0];
                        y += dirs[dir][1];
                        break;
                    case '\\':
                        switch (dir){
                            case R :
                                dir = D;
                                break;
                            case L :
                                dir = U;
                                break;
                            case U :
                                dir = L;
                                break;
                            case D :
                                dir = R;
                                break;
                        }
                        x += dirs[dir][0];
                        y += dirs[dir][1];
                        break;
                }
                cur = board[y][x];
            }
            board[y][x] = '&';
            System.out.println("HOUSE " + c);
            c++;
            for (int i = 0; i < l; i++) {
                String out = new String(board[i]);
                System.out.println(out);
            }
        }
    }
}
