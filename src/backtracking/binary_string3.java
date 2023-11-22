package backtracking;
// no 2 consecutive bit 1
// Based on pseudo code of Mr.Dung
public class binary_string3 {
    static int n = 3;
    static int[] x = new int[n];
    static void solution(){
        for(int k = 0; k < n; k++){
            System.out.print(x[k]);
        }
        System.out.println();
    }
    static boolean check(int v, int k){
        if(k == 0){
            return true;
        }
        return v + x[k-1] <= 1;
    }
    static void TRY(int k){
        for(int v = 0; v <= 1; v++){
            if(check(v,k)){
                x[k] = v;
                if(k == n-1){
                    solution();
                }
                else {
                    TRY(k+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        TRY(0);
    }
}
