import java.io.*;
import java.util.*;

//방문 배열 체크 리스트 배열을 만들고,인접리스트를 생성해야함
public class Main {
    static boolean[][] visit;
    static int [][]map;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
         map = new int[N + 1][N + 1];
         visit = new boolean[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean result = dfs(1, 1);
        System.out.println(result ? "HaruHaru" : "Hing");
    }
        static boolean dfs(int x, int y){
            if ( x== N && y ==N){
                return true;
            }
            if (x<1 || x>N || y<1 || y>N || visit[x][y]){ //맵의 범위에서 벗어난지 체크
                return false;
            }
            visit[x][y] = true;

            int jump = map[x][y];

            return dfs(x+jump,y) || dfs(x,y+jump);


      }
}
