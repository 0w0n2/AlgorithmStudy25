import java.util.*;

public class Main{
    static int[][] graph;
    static boolean[][] visited;
    static int M,N;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int result=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        int K = sc.nextInt(); // 직사각형 갯수

        // 크기 지정
        graph = new int[M+1][N+1];
        visited = new boolean[M+1][N+1];

        int[] square = new int[4];
        // 입력받기
        for (int i=0;i<K;i++) {
            for (int s = 0; s < square.length; s++) {
                square[s] = sc.nextInt();
            }

            // 방문처리와 그래프 1추가 동시진행
            for (int j=square[0];j<square[2];j++) {
                for (int k=square[1];k<square[3]; k++) {
                    // 방문하지 않은 위치 방문처리 그래프에 1 할당
                    if(!visited[k][j]){
                        visited[k][j] = true;
                        graph[k][j]=1;
                    }
                }
            }
        }

        // 중간 출력(여기까지 완!!)
         for (int i=0;i<M;i++) {
              for (int j=0;j<N;j++) {
                 System.out.print(graph[i][j]+" ");
              }
              System.out.println();
         }
        //0 0 0 0 1 1 0 
				//0 1 0 0 1 1 0 
				//1 1 1 1 0 0 0 
				//1 1 1 1 0 0 0 
				//0 1 0 0 0 0 0 
				
				// graph전체를 돌면서 0인곳만 bfs체크mport java.util.*;
public class Main{    static int[][] graph;    static boolean[][] visited;    static int M,N;    static int[] dx = {0,1,0,-1};    static int[] dy = {1,0,-1,0};    static int result=0;
    public static void main(String[] args) {        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();        N = sc.nextInt();        int K = sc.nextInt(); // 직사각형 갯수
        // 크기 지정        graph = new int[M+1][N+1];        visited = new boolean[M+1][N+1];
        int[] square = new int[4];        // 입력받기        for (int i=0;i<K;i++) {            for (int s = 0; s < square.length; s++) {                square[s] = sc.nextInt();            }
            // 방문처리와 그래프 1추가 동시진행            for (int j=square[0];j<square[2];j++) {                for (int k=square[1];k<square[3]; k++) {                    // 방문하지 않은 위치 방문처리 그래프에 1 할당                    if(!visited[k][j]){                        visited[k][j] = true;                        graph[k][j]=1;                    }                }            }        }
        // 중간 출력(여기까지 완!!)         for (int i=0;i<M;i++) {              for (int j=0;j<N;j++) {                 System.out.print(graph[i][j]+" ");              }              System.out.println();         }        //0 0 0 0 1 1 0 				//0 1 0 0 1 1 0 				//1 1 1 1 0 0 0 				//1 1 1 1 0 0 0 				//0 1 0 0 0 0 0 								// graph전체를 돌면서 0인곳만 bfs체크
        for (int i=0;i<=M;i++) {
            for (int j=0;j<=N;j++) {
                 result = bfs(i,j);
            }
        }
        System.out.println(result); // 2??
    }

    private static int bfs(int i, int j) {
        // 첫 스타트가 방문되있으면 종료
        if(visited[i][j]){
            return result;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        while(!q.isEmpty()){
            int[] nv = q.poll();

            for(int k=0;k<4;k++) {
                int nx = nv[0] + dx[k];
                int ny = nv[1] + dy[k];

                if(nx>=0 && ny>=0 && nx<=M && ny<=N && !visited[nx][ny] && graph[nx][ny]==0){
                    q.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    graph[nx][ny] =1;
                }
            }
        }
        return result++;
    }
}

