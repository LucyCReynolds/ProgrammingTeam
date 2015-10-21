import java.util.*;
public class BlackFriday {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean found = false;

        int n = in.nextInt();
        int[] rolls = new int[7];
        Arrays.fill(rolls,0);
        int[] index = new int[n];
        for(int i = 0; i < n; i++){
            int k = in.nextInt();
            index[i] = k;
            rolls[k]++;
        }
        int max = 0;
        for(int j = 6; j >0; j--){
           if(rolls[j] == 1){
               max = j;
               break;
           }
        }
        for(int r = 0; r < n; r++){
            if(index[r] == max){
                System.out.println(r+1);
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("none");
        }
    }
}
