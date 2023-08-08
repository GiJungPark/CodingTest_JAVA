import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        StringBuilder sb = new StringBuilder();
        
        int size = N.length();
        Integer[] A = new Integer[size];

        for(int i = 0; i < size; i++){
            A[i]= Integer.parseInt(N.substring(i, i+1));
        }

        Arrays.sort(A, Collections.reverseOrder());

        for(int i = 0; i < size; i++) {
            sb.append(A[i]);
        }

        System.out.println(sb.toString());
    }
}