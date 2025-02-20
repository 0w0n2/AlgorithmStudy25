import java.util.*;
import java.io.*;

public class Main {
	
	static int N, D; // 지름길 개수(간선 수), 도착하고 싶은 곳
	static ArrayList<ArrayList<Node>> map = new ArrayList<>();
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static class Node{
		int end, dist;
		Node(int end, int dist){
			this.end = end;
			this.dist = dist;
		}
	}
		
	public static void makeLoad() throws IOException { // O(D+N)
		
		for (int i=0;i<=D;i++) map.add(new ArrayList<>()); // 초기화
		for (int i=0;i<D;i++) map.get(i).add(new Node(i+1, 1)); // 한 칸씩 이동하는 기본 경로 추가
		
		for (int i=0;i<N;i++) { 
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			if (e-s>=d && e<=D) { // 지름길이 그냥 가는 것보다 더 길거나 지름길이 도착 지점을 초과하는 경우는 무시
				map.get(s).add(new Node(e, d)); // 입력으로 주어진 지름길 경로 추가
			}
		}
	}
	
	public static int dijkstra() {
		int[] dist = new int[D+1]; // 각 거리까지 도달하는 최단 경로 저장
		Arrays.fill(dist, Integer.MAX_VALUE); // INF // O(D)
		dist[0] = 0; // 시작 지점(거리 0)
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dist-o2.dist); // 각 거리 까지 가는데 필요한 최소 거리 저장
		
		pq.offer(new Node(0, 0)); // 시작 지점
		
		while(!pq.isEmpty()) {
			Node current = pq.poll(); // log(D)
			if (dist[current.end] != current.dist) continue; // 무효값
			
			for (Node nextPoint:map.get(current.end)) { // N
				int nd = nextPoint.dist + current.dist; 
				if (dist[nextPoint.end]>nd) {
					dist[nextPoint.end] = nd;
					pq.offer(new Node(nextPoint.end, nd)); // logD 
				} // NlogD
			}
		}
		return dist[D];
	}
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 지름길 개수(간선 수)
		D = Integer.parseInt(st.nextToken()); // 도착하고 싶은 곳
		makeLoad(); // 경로 만들기
		System.out.print(dijkstra()); // 다익스트라로 최소 경로 계산
		// O(DlogD + (D+N))
		// O((D+N)logD)
	}
}

