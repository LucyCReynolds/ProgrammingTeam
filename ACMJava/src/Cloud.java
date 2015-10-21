
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lucyreynolds on 4/16/15.
 */
public class Cloud {
    static final double frac = (9.0/16);
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int cloud = 1;
        for(;;){
            int w = in.nextInt();
            int n = in.nextInt();
            if(w == 0 && n == 0){
                break;
            }
            in.nextLine();
            ArrayList<Word> words = new ArrayList<>();
            int max = 0;

            for(int i = 0; i < n; i++){
                Word w1 = new Word();
                w1.w = in.next();
                w1.times = in.nextInt();
                if (w1.times > max){
                    max = w1.times;
                }
                words.add(w1);
            }

            int height = 0;
            int width = 0;
            int rowheight = 0;
            for (Word word : words) {
                int length = word.w.length();
                int p = 8 + (int) Math.ceil(((40.0) * (word.times - 4)) / (max - 4));
                int wid = (int)Math.ceil(frac * (double) length * (double) p);
                if (wid + width > w) {
                    height += rowheight;
                    rowheight = 0;
                    width = 0;
                }
                width += wid + 10;
                if (p > rowheight) {
                    rowheight = p;
                }

            }
            height +=rowheight;
            System.out.println("CLOUD " +cloud++ +": " + height);
        }
    }

    public static class Word{
        String w;
        int times;
    }
}
