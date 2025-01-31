import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] day;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        day = new int[N][M];

        Queue<int[]> queue = new LinkedList<>();
        boolean check = true;          // 첨부터 모두 익었는지 체크

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
                if (map[i][j] == 0) check = false;
            }
        }
        if (check) {
            System.out.println(0);
            return;
        }

        bfs(queue);

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {         // 안익은게 있는지
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, day[i][j]);   //날짜중 최대값
            }
        }
        System.out.println(result);
    }
    
    // bfs에 잘익은 토마토가 있는 위치를 한번에 넣어 여러개를 같이 bfs시작
    public static void bfs(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
                    map[nx][ny] = 1;
                    day[nx][ny] = day[x][y] + 1;    //동시에 bfs를 모두 진행해 day값이 가장 높은 날이 토마토 다 익은 날
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
