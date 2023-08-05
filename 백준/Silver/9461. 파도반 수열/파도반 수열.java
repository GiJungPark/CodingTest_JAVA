import java.util.Scanner;

public class Main {
    public static Long[] seq = new Long[101];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        seq[0] = 0L;
        seq[1] = 1L;
        seq[2] = 1L;
        seq[3] = 1L;

        for(int i = 0; i < size; i++){
            System.out.println(tri(sc.nextInt()));
        }
    }
    
    public static long tri(int num){
        if(seq[num] == null){
            seq[num] = tri(num - 2) + tri(num - 3);
        }
        return seq[num];
    }
}