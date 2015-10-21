import java.util.*;

public class paradox{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        for(int x = 0; x < c; x++){
            int cs = in.nextInt();
            int e = in.nextInt();
            ArrayList<Integer> comp = new ArrayList<>();
            ArrayList<Integer> econ = new ArrayList<>();
            double ctot = 0;
            double etot = 0;
            for(int i = 0; i < cs; i++){
                int n = in.nextInt();
                comp.add(n);
                ctot+=n;
            }
            for(int i = 0; i < e; i++){
                int n = in.nextInt();
                econ.add(n);
                etot+=n;
            }
            double cavg = ctot/cs;
            double eavg = etot/e;
            int rem = 0;
            Collections.sort(comp);
            for(;;){
                double catmp = 0;
                cs--;
                e++;
                rem++;
                for(int i = cs; i >= 0; i--){
                    catmp = ctot-comp.get(i);
                    if(catmp/cs > cavg){
                        int h = comp.get(i);
                        comp.remove(i);
                        ctot -= comp.get(i);
                        etot += comp.get(i);
                        if(etot/e > eavg){
                            System.out.println(rem);
                            return;
                        }
                    }
                }
            }

        }
    }
}