/**
 * Created by Dell on 12-11-2016.
 */
/*
* Sample Input

4
3 5
2 4
-1 -2
-1 3

Sample Output

243
16
n and p should be non-negative
n and p should be non-negative
*
*
* */
import java.util.*;
import java.io.*;
class NegativeException{

    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        int T=in.nextInt();
        while(T-->0)
        {
            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try
            {
                int ans=myCalculator.power(n,p);
                System.out.println(ans);

            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }

    }
}

class Calculator{

    int power(int n, int p) throws NegativeException{
        if(n<0 || p<0){
            throw new NegativeException();
        }
        return (int)Math.pow(n,p);
    }
}

class NegativeException extends Exception{

    public NegativeException(){

    }

    public String getMessage(){
        return "n and p should be non-negative";
    }
}