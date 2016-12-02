package binarSearchTree;

import java.io.*;
import java.util.*;

public class StringToChar {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tests = scan.nextInt();
        scan.nextLine();

        for(int i = 0; i<tests; i++){
            String str = scan.nextLine();
            char[] charArray = str.toCharArray();
            String odd="";
            String even="";

            for(char a=0;a<str.length();a++){
                if(a%2==0){
                    even+=charArray[a];
                }
                else
                    odd+=charArray[a];
            }
            System.out.println(even+" "+odd);
        }
    }
}
