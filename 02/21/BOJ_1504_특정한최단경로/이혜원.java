import java.util.*;
import java.io.*;

/*
 * 메모리 : 57264 KB, 시간 : 2336 ms
 * 플로이드를 이용해 문제 풀어보기
 * - 방향성이 없는 그래프 -> 양방향으로 간선 추가 필요
 * - 1에서 N으로 이동하는데 입력으로 주어지는 a, b를 반드시 거쳐야 함
 * 		-> 1->a->b->N 또는 1->b->a->N, 두 경로 중 최소 경로를 구하면 됨
 * 		-> 플로이드 워셜로 모든 노드 쌍의 최소 경로를 dp 배열에 저장하고,
 * 			① dp[1][a] + d[a][b] + d[b][N]
 * 			② dp[1][b] + d[b][a] + d[a][N]
 * 			중 최솟값을 찾는다.
 */

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수(노드)
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		int INF = 8_000_000;
		int[][] dist = new int[N+1][N+1];
		for (int i=1;i<=N;i++) { // O(N)
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}
		for (int i=0;i<E;i++) { // O(E)
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dist[a][b] = Math.min(dist[a][b], c);
			dist[b][a] = Math.min(dist[b][a], c);
			// 양방향으로 간선 추가
		}
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		// 플로이드-워셜로 모든 쌍의 최소 경로 구하기
		for (int a=1;a<=N;a++) { // O(N^3)
			for (int i=1;i<=N;i++) for (int j=1;j<=N;j++) {
				if(dist[i][a]!=INF&&dist[a][j]!=INF) dist[i][j] = Math.min(dist[i][j], dist[i][a]+dist[a][j]);
			}
		}
		int result = Math.min(dist[1][A]+dist[A][B]+dist[B][N], dist[1][B]+dist[B][A]+dist[A][N]);
		System.out.print(result>=INF ? -1:result);
		// O(N^3) -> 최대 O(512_000_000) 
	}
}

