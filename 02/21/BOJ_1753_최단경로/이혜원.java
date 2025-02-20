import java.util.*;
import java.io.*;

/*
 * 플로이드-워셜로 풀어보기
 * 방향 그래프(단방향)
 * 주어진 시작 점에서 다른 모든 정점으로의 최단 경로 출력 : dp[주어진 시작점][1~N] 모두 출력
 */
public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점의 개수(노드)
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수
        int start = Integer.parseInt(br.readLine());
        // 정점의 개수 (20,000)
        int[][] dist = new int[V+1][V+1];
        int INF = 1_000_000_000;
        for (int i=1;i<=V;i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dist[u][v] = Math.min(dist[u][v], w); // 단방향 그래프(u->w)
        }

        for (int k=1;k<=V;k++) {
            for (int i=1;i<=V;i++) for (int j=1;j<=V;j++) {
                if (dist[i][k]!=INF && dist[k][j]!=INF) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=1;i<=V;i++) {
            sb.append(dist[start][i]>=INF ? "INF" : dist[start][i]).append("\n");
        }
        System.out.print(sb);
    }
}
