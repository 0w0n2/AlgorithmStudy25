import java.util.*;
import java.io.*;

public class Main {
	static class Node{
		int v, cost;
		Node(int v, int cost){
			this.v = v;
			this.cost = cost;
		}
	}
	
	static int N, M;
	static ArrayList<ArrayList<Node>> map = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 도시의 개수(노드)
		M = Integer.parseInt(br.readLine()); // 버스의 개수(간선 수)

		for (int i=0;i<=N;i++) map.add(new ArrayList<>()); // 존재하는 모든 도시(노드) 업뎃 O(N)
		
		StringTokenizer st;
		for (int i=0;i<M;i++) { // 단방향 경로 (O(M))
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 시작 지점
			int e = Integer.parseInt(st.nextToken()); // 도착 지점
			int c = Integer.parseInt(st.nextToken()); // 비용
			map.get(s).add(new Node(e, c)); 
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()); // 시작 지점
		int end = Integer.parseInt(st.nextToken()); // 도착 지점
		dijkstra(start, end);
		// O(MlogN + NlogN)
	}
	
	public static void dijkstra(int start, int end) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE); // INF 로 초기화 (O(N))
		dist[start] = 0; // 자기 자신한테 가는 건 0
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost); // 최소 비용으로 가는 경로를 우선 계산
		pq.offer(new Node(start, 0)); // 시작 지점 O(logN)
		
		while(!pq.isEmpty()) { // O(N)
			Node current = pq.poll(); // 현재 탐색 O(logN)
			if(dist[current.v]!=current.cost) continue; // 쓰레기값 처리(이전에 current.v 에 대해서 다른 더 최소경로로 계산된 적 있음)
			
			for (Node nextPoint:map.get(current.v)) { // O(M)
				int nc = current.cost + nextPoint.cost; // 다음 도시(노드)에 대한 최소경로 후보
				if (dist[nextPoint.v]>nc) {
					dist[nextPoint.v] = nc;
					pq.offer(new Node(nextPoint.v, nc)); // O(logN)
				}
			}
		}
		System.out.print(dist[end]);
	}
}

