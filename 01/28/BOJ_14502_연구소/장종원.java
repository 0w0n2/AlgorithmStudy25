import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int maxresult = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combWall(0);
        System.out.println(maxresult);
    }
   
    public static void combWall(int cnt) {
        if (cnt == 3) {
            int[][] newMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                newMap[i] = map[i].clone();
            }

            dfs(newMap);
            maxresult = Math.max(maxresult, countSafe(newMap));
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    combWall(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    
    public static void dfs(int[][] newMap) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newMap[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && newMap[nx][ny] == 0) {
                    newMap[nx][ny] = 2;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
    
    public static int countSafe(int[][] newMap) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newMap[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
