package recursion;

import java.util.Scanner;

public class genString {
    static int n;
    static StringBuilder curString;

    public static void genString(int pos) {
        if (pos > n) {
            System.out.println(curString.toString());
            return;
        }
        for (char i = '0'; i <= '1'; i++) {
            curString.append(i);    // thêm ký tự mới vào dãy
            genString(pos + 1);
            curString.deleteCharAt(curString.length() - 1);      // bỏ ký tự này đi
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        curString = new StringBuilder();
        genString(1);
    }
}
