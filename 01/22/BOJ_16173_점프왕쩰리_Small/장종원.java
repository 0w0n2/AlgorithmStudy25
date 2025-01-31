import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static boolean result = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(result ? "HaruHaru" : "Hing");
    }

    public static void dfs(int x, int y) {
        if (result) return;                                                 //재귀함수를 사용하므로 중복으로 공간, 시간 복잡도 오류가 많이남
                                                                            // result가 이미 나온시점에선 모두 종료
        if (x < 0 || y < 0 || x >= N || y >= N || visited[x][y]) return;   //  visited[x][y]를 이용해 이미방문한 함수들도 모두 종료
        
        visited[x][y] = true;
        
        if (map[x][y] == -1) {                          //끝지점도착하면 result 반환
            result = true;
            return;
        }
        
        int jump = map[x][y];
        
        if (y + jump < N) {                             // 오른쪽
            dfs(x, y + jump);
        }

        if (x + jump < N) {                             //아래로
            dfs(x + jump, y);
        }
    }
}
