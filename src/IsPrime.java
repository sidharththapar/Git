/**
 * Created by Dell on 19-11-2016.
 */
import java.io.*;
import java.util.*;

public class IsPrime {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int[] test = new int[T];
        for(int i = 0; i<T; i++){
            test[i] = scan.nextInt();
            if(test[i]>=5)
                checkPrime(test[i]);
            else{
                if(test[i]==2 || test[i]==3)
                    System.out.println("Prime");
                else
                    System.out.println("Not prime");
            }
        }
        scan.close();
    }

    public static void checkPrime(int x){
        int flag = 0;


        if(x==2){
            System.out.println("Prime");
            return;
        }
        if(x==1 || (x & 1) == 0){
            System.out.println("Not prime");
            return;
        }

        for(int i=3; i<=Math.sqrt(x) ; i+=2){

            if(x%i == 0){
                System.out.println("Not prime");
                flag = 1;
                break;
            }
        }
        if(flag ==0)
            System.out.println("Prime");

    }
}

