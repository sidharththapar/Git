/**
 * Created by Dell on 11-11-2016.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TwoDArrayMaxHourGlass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        int maxHourGlass= maxSum(arr);
        System.out.println(maxHourGlass);
    }

    public static int maxSum(int[][] arr){
        int sumHourGlass=-63;
        for(int i=0; i < 4; i++){
            for(int j=0; j < 4; j++){
                int sumCurrHourGlass = arr[i][j]  + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] +
                        arr[i+2][j+2];
                if(sumCurrHourGlass > sumHourGlass)
                    sumHourGlass = sumCurrHourGlass;
            }
        }
        return sumHourGlass;
    }

}