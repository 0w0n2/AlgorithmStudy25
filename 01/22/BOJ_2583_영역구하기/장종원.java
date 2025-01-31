import java.io.*;
import java.util.*;

public class Main {

    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};                         // 상하좌우
    static int[] dy = {-1, 1, 0, 0};
    static List<Integer> areas = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        
        for (int i = 0; i < K; i++) {                       //직사각형 표시
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = 1; 
                }
            }
        }
        
        for (int i = 0; i < M; i++) {                   // dfs
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    int areaSize = dfs(i, j);
                    areas.add(areaSize);
                }
            }
        }
        
        Collections.sort(areas);                // 영역 크기 오름차순 정렬
        System.out.println(areas.size());
        for (int area : areas) {
            System.out.print(area + " ");
        }
    }

    public static int dfs(int y, int x) {
        visited[y][x] = true;
        int areaSize = 1;

        // 상하좌우 탐색
        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (ny >= 0 && ny < M && nx >= 0 && nx < N && !visited[ny][nx] && map[ny][nx] == 0) {
                areaSize += dfs(ny, nx);
            }
        }

        return areaSize;
    }
}
