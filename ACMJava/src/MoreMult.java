import java.util.*;

public class MoreMult {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(;;) {
            int op1 = in.nextInt();
            char[] st1 = String.valueOf(op1).toCharArray();
            int op2 = in.nextInt();
            char[] st2= String.valueOf(op2).toCharArray();
            if(op1 == 0 && op2 ==0){
                break;
            }
            int w = (st1.length*4) +5;
            int l = (st2.length*4) +5;

            char[][] box = new char[l][w];
            for (int i = 0; i < l; i++) {
                Arrays.fill(box[i], ' ');
            }
            box[0][0] = '+';
            box[0][w-1] = '+';
            box[l-1][0] = '+';
            box[l-1][w-1] = '+';
            for (int i = 1; i < w-1; i++) {
                box[0][i] = '-';
                box[l-1][i] = '-';
            }
            for (int i = 1; i < l-1; i++) {
                box[i][0] = '|';
                box[i][w-1] = '|';
            }
            for (int i = 0; i < st1.length; i++) {
                for (int j = 0; j < st2.length; j++) {
                    box[2+4*j][2+4*i] = '+';
                    box[(2+4*j)+1][(2+4*i)] = '|';
                    box[(2+4*j)+2][(2+4*i)] = '|';
                    box[(2+4*j)+3][(2+4*i)] = '|';
                    box[(2+4*j)+4][(2+4*i)] = '+';
                    box[(2+4*j)][(2+4*i)+1] = '-';
                    box[(2+4*j)][(2+4*i)+2] = '-';
                    box[(2+4*j)][(2+4*i)+3] = '-';
                    box[(2+4*j)][(2+4*i)+4] = '+';

                    box[5+4*j][3+4*i] = '/';
                    box[(5+4*j)-1][(3+4*i)+1] = '/';
                    box[(5+4*j)-2][(3+4*i)+2] = '/';
                    int x = Integer.parseInt(String.valueOf(st1[i]));
                    int y = Integer.parseInt(String.valueOf(st2[j]));
                    char[] mult = String.valueOf(x * y).toCharArray();
                    if(mult.length == 2){
                        box[3+4*j][3+4*i] = mult[0];
                        box[5+4*j][5+4*i] = mult[1];
                    }
                    else {
                        box[3+4*j][3+4*i] = '0';
                        box[5+4*j][5+4*i] = mult[0];
                    }
                }
                box[l-3][(2+4*(i+1)-1)] = '-';
                box[l-3][(2+4*(i+1)-2)] = '-';
                box[l-3][(2+4*(i+1)-3)] = '-';
                box[l-3][(2+4*(i+1))] = '+';
            }

            for (int i = 0; i < st2.length; i++) {
                box[(2+4*i)+1][w-3] = '|';
                box[(2+4*i)+2][w-3] = '|';
                box[(2+4*i)+3][w-3] = '|';
            }

            for (int i = 1; i <= st1.length; i++) {
                box[1][4*i] = st1[i-1];
            }
            for (int i = 1; i <= st2.length; i++) {
                box[4*i][w-2] = st2[i-1];
            }


            char[] answer = String.valueOf(op1*op2).toCharArray();

            int index = answer.length-1;
            for (int j = 0; j < st1.length; j++) {
                box[l-2][(w-6)-4*j] = answer[index];
                if(index>0) {
                    box[l - 2][((w - 6) - 4 * j) - 2] = '/';
                }
                index--;
                if(index == -1){
                    break;
                }
            }
            if(index >= 0){
                for(int i = 1;index >=0;i++){
                    box[l-4*i][1] = answer[index];
                    box[(l-4*i)+2][1] = '/';
                    index--;
                }
            }
            for (int i = 0; i < l; i++) {
                System.out.println(new String(box[i]));
            }
        }
    }
}