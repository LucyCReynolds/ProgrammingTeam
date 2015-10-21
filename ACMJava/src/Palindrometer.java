/**
 * Created by lucyreynolds on 4/21/15.
 */
import java.util.Scanner;


public class Palindrometer {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        for(;;){

            String input = in.nextLine();
            int length = input.length();
            Integer pal = Integer.parseInt(input);
            if(pal == 0){
                break;
            }

            int miles = 0;

            while(true){
                String str = toS(pal, length);
                String rev = new StringBuffer(str).reverse().toString();

                if(str.equals(rev)){
                    break;
                }
                pal++;
                miles++;
            }
            System.out.println(miles);
        }
        in.close();
    }

    public static String toS(Integer in, int length){
        char[] c = in.toString().toCharArray();
        String ret = new String(c);
        for(int i = 0; i < length - c.length; i++){
            ret = "0" + ret;
        }
        return ret;
    }
}
