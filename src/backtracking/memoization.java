package backtracking;
//Based on pseudo code of Mr.Dung
public class memoization {
    static final int MAX = 100;
    static int[][] m = new int[MAX][MAX];
    public static void main(String[] args) {
        for(int i = 0; i < 50; i++){
            for(int j = 0; j < 50; j++){
                m[i][j] = -1;
            }
        }
        System.out.println(C(15,23));
    }
     static int C(int k, int n){
        if(k == 0 || k == n ){
            m[k][n] = 1;
        }else {
            if(m[k][n] < 0){
                m[k][n] = C(k-1, n-1) + C(k,n-1);
            }
        }
        return m[k][n];
    }
}
