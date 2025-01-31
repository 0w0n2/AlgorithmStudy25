import java.io.*;
import java.util.*;

public class Main {
    static int m, n;
    static int [][] map;
    static int [][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int [m][n];
        dp = new int[m][n];

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0, 0));
    }
    public static int dfs(int x, int y){

        if (x == (m - 1) && y == (n - 1)) return 1; // 도달 시 경로 +1

        if (dp[x][y]!=-1) return dp[x][y];
        // 이전에 방문해본 지점이면 해당 지점에서 가능한 경로가 총 몇 가지인지 dp[][] 배열에 저장되어 있음
        // -> 다시 계산 안 하고 저장값을 바로 리턴함으로써 재귀 호출 횟수 ↓

        int [] dx = {1, -1, 0, 0};
        int [] dy = {0, 0, 1, -1};

        dp[x][y] = 0; // 0으로 초기화

        for (int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx<0 || nx>=m || ny<0 || ny>=n || map[nx][ny]>=map[x][y]) continue;
            dp[x][y] += dfs(nx, ny); // 해당 지점에서 가능한 경로를 모두 dp에 저장
        }
        return dp[x][y];
    }
}

