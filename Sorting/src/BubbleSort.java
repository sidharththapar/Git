import java.io.*;
import java.util.*;

public class BubbleSort {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        s.nextLine(); // throw away the newline.

        int [] a = new int[n];
        Scanner numScanner = new Scanner(s.nextLine());
        for (int i = 0; i < n; i++) {
            if (numScanner.hasNextInt()) {
                a[i] = numScanner.nextInt();
            } else {
                System.out.println("You didn't provide enough numbers");
                break;
            }
        }

        BubbleSort sol= new BubbleSort();
        /*for (int abc=0;abc<n;abc++)
        System.out.println(a[abc]);*/
        sol.calculateSwaps(n,a);
    }

    public void calculateSwaps(int n, int[] a){
        int totalSwaps = 0;
        outerloop:
        for (int i = 0; i < n; i++) {
            int numberOfSwaps = 0;
            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    a[j] = a[j] + a[j+1];
                    a[j+1] = a[j] - a[j+1];
                    a[j] = a[j] - a[j+1];
                    //swap(j ,j + 1,a[j],a[j+1],a);
                    numberOfSwaps++;
                }
            }
            if (numberOfSwaps == 0)
                break outerloop;
            totalSwaps += numberOfSwaps;
        }
        printSwapsAndElements(n ,a ,totalSwaps);
    }
    /*   public void swap(int m,int n,int x, int y,int[] a) {
           a[m] = x;
           a[n] = y;
       }*/
    public void printSwapsAndElements(int n,int[] a, int totalSwaps){
        try {
            BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

            log.write("Array is sorted in "+totalSwaps+" swaps.\n"+"First Element: "+a[0]+"\nLast Element: "+a[(a.length)-1]);
            log.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
