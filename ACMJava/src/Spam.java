import java.util.*;

public class Spam {
    public static void main(String[] args){
        double space = 0, low = 0, up = 0, sym = 0;
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        char[] a = input.toCharArray();
        int l = a.length;
        for(char c: a){
            int x = ((int)c);
            if(x < 65){
                sym++;
            }
            else if(x < 91){
                up++;
            }
            else if(x == 95){
                space++;
            }
            else if(x < 97){
                sym++;
            }
            else if(x < 123){
                low++;
            }
            else{
                sym++;
            }
        }
        space /= l;
        low /= l;
        up /= l;
        sym /= l;
        System.out.printf("%.15f\n", space);
        System.out.printf("%.15f\n", low);
        System.out.printf("%.15f\n", up);
        System.out.printf("%.15f\n", sym);

    }
}
