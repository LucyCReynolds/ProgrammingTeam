import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class RPS {
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        for(;;){
            String read = in.readLine();
            String[] vars = read.split(" ");
            int n = Integer.parseInt(vars[0]);
            if(n == 0){
                break;
            }
            int k =  Integer.parseInt(vars[1]);
            int games = (k * n *(n-1))/2;
            ArrayList<Pair> players= new ArrayList<>();
            for(int i = 0; i < n; i++){
                players.add(i, new Pair());
            }
            for (int j = 0; j < games; j++){
                String g = in.readLine();
                String[] a = g.split(" ");
                int p1 = Integer.parseInt(a[0])-1;
                String h1 = a[1];
                int p2 = Integer.parseInt(a[2])-1;
                String h2 = a[3];

                if(h1.equals(h2)){}
                else if((h1.equals("rock") && h2.equals("scissors")) || (h1.equals("scissors") && h2.equals("paper")) || (h1.equals("paper") && h2.equals("rock"))){
                    players.get(p1).incWin();
                    players.get(p2).incLoss();
                }
                else{
                    players.get(p1).incLoss();
                    players.get(p2).incWin();
                }
            }
            for (int y = 0; y < n; y++) {
                Pair p = players.get(y);
                if(p.win+p.loss == 0){
                    System.out.println("-");
                }
                else {
                    double avg = (p.win / (p.win + p.loss));
                    System.out.printf("%.3f\n", avg);
                }
            }
            System.out.println();
        }
    }

    public static class Pair{
        double win;
        double loss;
        public Pair(){
            win = 0;
            loss = 0;
        }
        public void incWin(){
            this.win++;
        }
        public void incLoss(){
            this.loss++;
        }
    }
}
