/**
 * Created by Dell on 11-11-2016.
 */
import java.io.*;
import java.util.*;

public class BinaryMaxConsecOnes {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int len = 0;
        Stack stack = new Stack();
        while (num>0){
            Integer rem = num % 2;
            stack.push(rem);
            len++;
            num/=2;
        }
        Integer[] arr = new Integer[len];
        try {
            for(int i = 0; i<len ; i++){
                arr[i] = (Integer) stack.pop();
            }
        }
        catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
        int maxConsecutiveOnes = countMaxOnes(arr);
        System.out.println(maxConsecutiveOnes);
    }

    //Count Maximum number of consecutive 1s
    public static int countMaxOnes(Integer[] arr){
        int maxLength = 0;
        int tempLength = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 1) {
                tempLength++;
            } else {
                tempLength = 0;
            }

            if (tempLength > maxLength) {
                maxLength = tempLength;
            }
        }
        return maxLength;
    }
}
