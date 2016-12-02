import java.io.*;
import java.util.*;

public class RecursionFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(factorial(n));
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }

    public static int factorial(int n){
        if (n <=1)
            return 1;
        else
            return n * factorial(n-1);
    }
}