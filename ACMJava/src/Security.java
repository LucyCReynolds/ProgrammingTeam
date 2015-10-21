import java.util.*;
public class Security {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final String[] code = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "..--", ".-.-", "---.", "----"};
        final String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "_", ",", ".", "?"};
        while (in.hasNext()){
            char[] a = in.nextLine().toCharArray();
            ArrayList<Integer> nums = new ArrayList<>();
            String result = "";
            for(char x:a){
                switch (x){
                    case '_':
                        nums.add(4);
                        result = result + code[26];
                        break;
                    case ',':
                        nums.add(4);
                        result = result + code[27];
                        break;
                    case '.':
                        nums.add(4);
                        result = result + code[28];
                        break;
                    case '?':
                        nums.add(4);
                        result = result + code[29];
                        break;
                    default:
                        String s = code[x-'A'];
                        int l = s.length();
                        result = result + s;
                        nums.add(l);
                        break;
                }
            }
            int index = 0;
            Collections.reverse(nums);
            ArrayList<String> codes = new ArrayList<>(Arrays.asList(code));
            String note = "";
            for(int i: nums){
                String s = result.substring(index, index+i);
                note = note + letters[codes.indexOf(s)];
                index += i;
            }
            System.out.println(note);
        }
    }
}