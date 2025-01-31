import java.util.Scanner;

public class Main{
    static int[][] map;
    static boolean[][] visited;
    static int M,N;
    static int count=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        dfs(0,0);
        System.out.println(count);
    }

    private static void dfs(int i, int j) {
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};

        visited[i][j] = true;
        int place = map[i][j];

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = i + dy[k];

            if(x>=0 && x<M && y>=0 && y<N && !visited[x][y]){
                if(place > map[x][y]){
                    dfs(x,y);
                    visited[x][y]=false;
                }
            }
            count++;
        }
    }
}

