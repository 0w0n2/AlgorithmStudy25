import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int count = 0;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSize = 0;
        for(int i = 0; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    int areaSize = bfs(i, j);
                    count++;
                    maxSize = Math.max(maxSize, areaSize);
                }
            }
        }
        System.out.println(count);
        System.out.println(maxSize);
    }

    public static int bfs(int i, int j) {
        queue.add(new int[] {i, j});
        visited[i][j] = true;
        int areaSize = 1;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for(int dir=0; dir < 4 ; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                    areaSize++;
                }
            }
        }
        return areaSize;
    }
}
