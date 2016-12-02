import java.util.*;
import java.io.*;

class HashMapDictionary{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String,Integer> hash = new HashMap<String,Integer>();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            hash.put(name,phone);
            // Write code here
        }
        while(in.hasNext()){
            String s = in.next();
            Integer value = hash.get(s);
            if (value != null) {
                System.out.println(s + "=" + value);
            }
            else {
                if (hash.containsKey(s)) {
                    System.out.println("Null Value");
                } else {
                    System.out.println("Not found");
                }
            }
        }
        in.close();
    }
}