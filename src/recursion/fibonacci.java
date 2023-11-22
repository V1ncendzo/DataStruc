package recursion;

import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the index of the fibonacci serires 'element");
        int index = sc.nextInt();
        System.out.println("Index of the fibonacci series' element " + index + " is " + fibo(index));
    }

    private static int fibo(int i) {
        if(i == 1){
            return 1;
        } else if (i == 2) {
            return 1;
        }else {
            return fibo(i-1) + fibo(i-2);
        }
    }
}
