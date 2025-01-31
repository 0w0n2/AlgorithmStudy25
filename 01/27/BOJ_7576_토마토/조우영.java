import java.util.*;

public class Main{
    static int[][] graph;
    static boolean[][] visited;
    static int m,n,day;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        // 그래프와 방문배열 생성
        graph = new int[n][m];
        visited = new boolean[n][m];

        // graph 생성, 1인 곳(시작 점)을 큐에 저장 (0,0) 바로 다음 (3,5)가 쌓이게 됨
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                graph[i][j] = sc.nextInt();
                if(graph[i][j] == 1){
                    q.add(new int[]{i,j});
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while(!q.isEmpty()){
        
            int[] nv = q.poll();

            for (int k=0;k<4;k++) {
                int x = nv[0] + dx[k];
                int y = nv[1] + dy[k];

                if(x>=0 && y>=0 && x<m && y<n && graph[x][y]==0){
                    q.add(new int[]{x,y});
                    graph[x][y]++;
                }
            }
            day++;
        }
        return day;
    }
}

