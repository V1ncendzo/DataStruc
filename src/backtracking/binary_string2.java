package backtracking;
//Based on pseudo code of Mr.Dung
public class binary_string2 {
    static int COUNT = 0;
    static int n = 3; // Đặt giá trị n theo yêu cầu của bạn
    static int[] x = new int[n];

    static void solution() {
        for (int k = 0; k < n; k++) {
            System.out.print(x[k]);
        }
        System.out.println();
    }

    static void TRY(int k) {
        for (int v = 0; v <= 1; v++) {
            x[k] = v;
            if (k == n - 1) {
                solution();
                COUNT += 1;
            } else {
                TRY(k + 1);
            }
        }
    }

    public static void main(String[] args) {
        TRY(0);
        System.out.println("The tota number of binary string: " + COUNT);
    }
}
