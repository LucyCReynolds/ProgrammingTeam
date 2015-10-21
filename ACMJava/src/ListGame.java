import java.util.*;
public class ListGame {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int input = in.nextInt();
        int ceil = (int)Math.ceil(Math.sqrt((double)input));
        ArrayList<Integer> nums = new ArrayList<>();

        for(int i = 2; input > 1 ; i++){
            if(i > ceil){
                nums.add(0);
                break;
            }
            while(input%i == 0){
                nums.add(i);
                input = input/i;
            }
        }

        System.out.println(nums.size());
    }
}
