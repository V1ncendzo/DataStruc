package backtracking;
// Code done by MR.Dung
public class Sudoku2 {
    int[][] x;// solution representation
    boolean[][] markR;// markR[r][v] = true means that value v has been used on row r
    boolean[][] markC;// markC[c][v] = true means that value v has been used on column c
    boolean[][][] markS;// markS[I][J][v] = true means that value v has been used in the sub-square(I,J)

    boolean check(int v, int r, int c){
        if(markR[r][v] == true) return false;// v has been used on row r
        if(markC[c][v] == true) return false;// v has been used on column c
        if(markS[r/3][c/3][v] == true) return false;
        return true;
    }
    void solution(){
        for(int i = 0; i <= 8; i++){
            for(int j = 0; j <= 8; j++)
                System.out.print(x[i][j] + " ");
            System.out.println();
        }
        System.out.println("----------------");
    }
    void Try(int r, int c){// try values for x[r][c]
        for(int v = 1; v <= 9; v++){
            if(check(v,r,c)){
                x[r][c] = v;// v appears on row r and column c, sub-square(r/3,c/3)
                markR[r][v] = true;
                markC[c][v] = true;
                markS[r/3][c/3][v] = true;
                if(r == 8 && c == 8) solution();
                else{
                    if(c < 8) Try(r, c+1);
                    else Try(r+1,0);
                }
                markR[r][v] = false;
                markC[c][v] = false;
                markS[r/3][c/3][v] = false;
            }
        }
    }
    void solve(){
        x = new int[9][];
        for(int i = 0; i < 9; i++) x[i] = new int [9];
        markR = new boolean[9][];
        for(int i = 0; i < 9; i++) markR[i] = new boolean[10];
        markC = new boolean[9][];
        for(int i = 0; i < 9; i++) markC[i] = new boolean[10];
        markS = new boolean[3][][];
        for(int j = 0; j <= 2; j++){
            markS[j] = new boolean[3][];
            for(int i = 0; i <= 2; i++)
                markS[j][i] = new boolean[10];
        }
        Try(0,0);
    }
    public static void main(String[] args){
        Sudoku2 app = new Sudoku2();
        app.solve();
    }
}
