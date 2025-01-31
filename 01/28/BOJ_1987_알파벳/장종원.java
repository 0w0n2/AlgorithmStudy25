import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static List<Character> visited = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int count = 0;
    static int maxresult = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int i = 0; i < R ; i++) {
            String lines = br.readLine();
            for(int j = 0; j < C ; j++) {
                map[i][j] = lines.charAt(j);
            }
        }
        dfs(0,0);
        System.out.println(maxresult);
    }

    public static void dfs(int x, int y) {
        visited.add(map[x][y]);
        count++;
        maxresult = Math.max(maxresult, count);

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];                  // contains가 시간복잡도 n이라 boolean배열 만들어서 체크하는게 좋을듯
            if (nx >= 0 && ny >= 0 && nx < R && ny < C &&!visited.contains(map[nx][ny])) {
                dfs(nx, ny);
            }
        }

        visited.remove(visited.size() - 1);
        count--;
    }
}
