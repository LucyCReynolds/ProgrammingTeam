import java.util.*;

public class Toilet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] line = in.nextLine().toCharArray();
        int up = 0;
        int down = 0;
        int like = 0;
        boolean curUp = (line[0] == 'U');

        if (curUp) {
            if (line[1] == 'U') {
                down++;
            }
            else {
                curUp = false;
                like++;
                up+=2;
                down++;
            }
        }
        else{
            if(line[1] == 'D'){
                up++;
            }
            else {
                curUp = true;
                like++;
                down+=2;
                up++;
            }
        }

        for(int i = 2; i < line.length; i++){
            switch (line[i]){
                case 'U':
                    down+=2;
                    if(!curUp){
                        curUp = true;
                        like++;
                    }
                    break;
                case 'D':
                    up+=2;
                    if(curUp){
                        curUp = false;
                        like++;
                    }
                    break;
            }
        }

        System.out.printf("%d%n%d%n%d%n",up,down,like);

    }
}
