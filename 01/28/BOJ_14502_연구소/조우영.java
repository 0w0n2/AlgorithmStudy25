import java.util.*;

public class Main{
    static int[][] map;
    static boolean[][] visited;
    static int n,m;
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    static int maxSafeZone=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 크기 및 수 할당
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

				// 벽세우기를 위한 dfs시작
        dfs(0);`
        System.out.println(maxSafeZone);
    }

    private static void dfs(int wallCnt) {
		    // 벽 3개면 마무리하고 바이러스 감염 시작
        if(wallCnt ==3){
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]==0){
                    map[i][j]=1;
                    dfs(wallCnt+1);
                    map[i][j]=0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        // 바이러스 위치를 큐에 추가
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]==2){
                    q.add(new int[]{i, j});
                }
            }
        }
        
        // 카피 맵 - 맵 청소
        int[][] copyMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            copyMap[i] = map[i].clone();
        }

        // 바이러스 퍼뜨리기
        while(!q.isEmpty()){
            int[] nv = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = nv[0] + dx[i];
                int y = nv[1] + dy[i];
                if(x>=0 && y>=0 && x<n && y<m && copyMap[x][y]==0){
                    q.add(new int[]{x,y});
                    copyMap[x][y]=2;
                }
            }
        }

        // 세이프존 확인, 최대갯수를 변수에 저장
        int safeZone=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(copyMap[i][j]==0){
                    safeZone++;
                }
            }
        }
        
        maxSafeZone = Math.max(maxSafeZone, safeZone);
    }
}

