import java.io.*;

public class Main{
    static char[][] graph;
    static boolean[] alpha = new boolean[26];
    static int[] dx = {1,0,-1,0}; // 우,상,좌,하
    static int[] dy = {0,1,0,-1};
    static int max,count=0;
    static int R,C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        R = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);

        // 크기 생성 및 알파벳 할당
        graph = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine(); // CAAB
            for (int j = 0; j < input.length(); j++) {
                graph[i][j] = input.charAt(j); // graph[0][j] = [C, A, A, B]
            }
        }

        dfs(0,0,1);
        System.out.println(max);
    }

    private static void dfs(int i, int j, int count) {
        max = Math.max(max, count);
        alpha[graph[i][j] - 'A'] = true;

        for (int l = 0; l < 4; l++) {
            int x = i + dx[l];
            int y = j + dy[l];

            if(x>=0 && x<R && y>=0 && y<C && !alpha[graph[x][y] - 'A']) {
                dfs(x,y, count+1);
            }
        }
        // 갔다가 돌아와서는 방문처리 해제
        alpha[graph[i][j] - 'A'] = false;
    }
}
