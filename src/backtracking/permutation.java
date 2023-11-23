package backtracking;
//Code done by Mr.Dung
import java.util.Scanner;

public class permutation {
    int n;// input
    int[] x;// solution representation
    boolean[] mark;// mark[v] = true means that value v has been used in the partial solution
    boolean check(int v, int k){
        return mark[v] == false;// accept value not used
    }
    void solution(){
        for(int i = 1; i <= n; i++) System.out.print(x[i] + " ");
        System.out.println();
    }
    void Try(int k){
        for(int v = 1; v <= n; v++){
            if(check(v,k)){
                x[k]=v;
                mark[v] = true;// update status when taking decision x[k] = v
                if(k == n) solution();
                else Try(k+1);
                mark[v] = false;// recover when backtracking (do not take decision x[k] = v)
            }
        }
    }
    void solve(){
        try{
            Scanner in = new Scanner(System.in);
            n = in.nextInt();
            x = new int[n+1];
            mark = new boolean[n+1];
            for(int v = 1; v <= n; v++) mark[v] = false;
            Try(1);
        }catch(Exception e){ e.printStackTrace();}

    }
    public static void main(String[] args){
        permutation app = new permutation();
        app.solve();
    }
}
