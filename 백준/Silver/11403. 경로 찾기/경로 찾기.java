import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        initMap(br);
        searchMap();
        printMap(bw);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initMap(BufferedReader br) throws Exception {
        StringTokenizer st;
        map = new int[N][N];
        for(int j = 0; j < N; j++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < N; k++){
                map[j][k] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void searchMap(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    if(map[j][i] == 1 && map[i][k] == 1)
                        map[j][k] = 1;
                }
            }
        }
    }

    private static void printMap(BufferedWriter bw) throws Exception {
        for(int j = 0; j < N; j++){
            for(int k = 0; k < N; k++){
                bw.write(map[j][k] + " ");
            }
            bw.write("\n");
        }
    }
}