import java.util.*;


public class Cashiers {
    
    public ArrayList<Integer> makeChange(int n, int coins[]){

        ArrayList<Integer> Solution = new ArrayList<Integer>();
        int index = coins.length-1;

        while(index >=0){

            while(coins[index] <= n){
                Solution.add(coins[index]);
                n = n - coins[index];
            }

            index--;
        }

        return Solution;
    }


    public static void main(String[] args) {

        Cashiers problem = new Cashiers();
        int coins[] = new int[] { 1, 5, 10, 25, 50, 100};
        int n = 77;

        ArrayList<Integer> Solution = problem.makeChange(n, coins);

        System.out.println("Quantidade de moedas: " + Solution.size());
        System.out.println("Moedas selecionadas: " + Solution.toString());
    }
}