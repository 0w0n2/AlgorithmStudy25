import java.util.*;

public class Main{
    static int[][] graph;
    static boolean[][] visited;
    static int M,N;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int count=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        // 크기 지정
        graph = new int[M+1][N+1];
        visited = new boolean[M+1][N+1];

        // 입력받기
        for (int i=0;i<M;i++){
            for (int j=0;j<N;j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        // graph 돌면서 bfs 돌리기
        int maxResult =0;
        for (int i=0;i<=M;i++) {
            for (int j=0;j<=N;j++) {
                if(graph[i][j]==1 && !visited[i][j]){
                     count++;
                     int size = bfs(i,j);
                     maxResult = Math.max(size, maxResult);
                }
            }
        }
        System.out.println(count);
        System.out.println(maxResult);
    }

    private static int bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        int size=0;

        while(!q.isEmpty()){
            int[] nv = q.poll();
            size++;

            for(int k=0;k<4;k++) {
                int nx = nv[0] + dx[k];
                int ny = nv[1] + dy[k];
                if(nx>=0 && ny>=0 && nx<M && ny<N && !visited[nx][ny] && graph[nx][ny]!=0){
                    q.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return size;
    }
}
