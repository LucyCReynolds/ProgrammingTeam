import java.util.Scanner;

/**
 * Created by lucyreynolds on 4/21/15.
 */
public class TextRoll {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        for(;;){
            int lines = in.nextInt();

            if(lines == 0){
                break;
            }
            in.nextLine();
            char[][] text = new char[lines][];
            int length = 0;

            for(int i = 0; i < lines; i++){
                text[i] = in.nextLine().toCharArray();
                if(text[i].length > length){
                    length = text[i].length;
                }
            }

            int r = 0;
            int c = 0;

            while(r < lines){
                if(c>= text[r].length || text[r][c] == ' '){
                    r++;
                }
                else
                    c++;
            }
            System.out.println(++c);
        }
    }
}
