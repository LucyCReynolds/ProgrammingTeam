import java.util.*;
public class Peragram {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        char[] input = in.nextLine().toCharArray();
        int[] let = new int[26];
        Arrays.fill(let,0);
        for(char c: input){
            let[c-'a']++;
        }
        int odds = 0;
        for(int k:let){
            if(k%2 != 0){
                odds++;
            }
        }
        if(odds == 0){
            System.out.println(0);
        }
        else {
            System.out.println(odds - 1);
        }
    }
}
